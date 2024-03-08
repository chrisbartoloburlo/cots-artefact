import PyPDF2
import os
import sys
import tkinter as tk
from tkinter.filedialog import askdirectory
from tkinter import filedialog
from tkinter import *
import glob
import shutil

global name

class App(tk.Tk):
   def __init__(self):
      super().__init__()


def open_st_file_dialog():
  file_path = filedialog.askopenfilename(title="Select .st file", filetypes=[("Text files", "*.st")])
  if file_path:
      global st_path 
      st_path = file_path
      selected_file_label.config(text=f"Selected File: {file_path}")

def open_openapi_file_dialog():
  file_path = filedialog.askopenfilename(title="Select OpenAPI schema file", filetypes=[("Text files", "*.yaml"), ("Text files", "*.json")])
  if file_path:
      global openapi_path 
      openapi_path = file_path
      selected_file_label_2.config(text=f"Selected File: {file_path}")

def open_util_file_dialog():
  file_path = filedialog.askopenfilename(title="Select Util file", filetypes=[("Text files", "*.scala")])
  if file_path:
      global util_path 
      util_path = file_path
      selected_file_label_3.config(text=f"Selected File: {file_path}")

def getDirname():
  global dirname
  dirname = askdirectory()
  selected_file_label_4.config(text=f"Selected Directory: {dirname}")

def generate_driver():
  name = T.get("1.0",END).strip()
  tmpFiles = glob.glob('./tmp/*')
  for f in tmpFiles:
    os.system('rm -r '+f)
  os.system('java -jar ./openapi-generator-cli.jar generate -i '+openapi_path+' -g scala-sttp --skip-validate-spec -o ./tmp --additional-properties modelPropertyNaming=original')
  os.system('rm -r ./tmp/.openapi-generator/')
  os.system('rm ./tmp/.openapi-generator-ignore')
  os.system('rm ./tmp/build.sbt')
  os.system('rm ./tmp/README.md')
  os.system('rm -r ./tmp/project/')
  os.system('mv ./tmp/src/main/scala/org/openapitools/client/api/ ./tmp')
  os.system('mkdir ./tmp/api')
  apiFiles = glob.glob('./tmp/api/*')
  for f in apiFiles:
      f_obj = open(f, "r")
      contents = f_obj.read().replace("package org.openapitools.client.api",
                                      "package " + name + ".api").replace("import org.openapitools.client",
                                                                                    "import " + name)
      contents = contents.replace("import examples." + name + ".model.AnyType\n", "")
      f_obj.close()
      f_obj = open(f, "w")
      f_obj.write(contents)
      f_obj.close()
  os.system('mv ./tmp/src/main/scala/org/openapitools/client/core/ ./tmp')
  os.system('mkdir ./tmp/core')
  coreFiles = glob.glob('./tmp/core/*')
  for f in coreFiles:
      f_obj = open(f, "r")
      contents = f_obj.read().replace("package org.openapitools.client.core",
                                      "package " + name + ".core").replace("import org.openapitools.client",
                                                                                    "import " + name)
      f_obj.close()
      f_obj = open(f, "w")
      f_obj.write(contents)
      f_obj.close()
  os.system('mv ./tmp/src/main/scala/org/openapitools/client/model/ ./tmp')
  os.system('mkdir ./tmp/model')
  modelFiles = glob.glob('./tmp/model/*')
  for f in modelFiles:
      f_obj = open(f, "r")
      contents = f_obj.read().replace("package org.openapitools.client.model",
                                      "package " + name + ".model").replace("import org.openapitools.client",
                                                                                      "import " + name)
      f_obj.close()
      f_obj = open(f, "w")
      f_obj.write(contents)
      f_obj.close()
  os.system('rm -r ./tmp/src/')
  os.system('mkdir ./tmp/src/')
  os.system('mkdir ./tmp/src/main/')
  os.system('mkdir ./tmp/src/main/scala/')
  os.system('mkdir ./tmp/src/main/scala/'+name+'/')
  os.system('mv ./tmp/model ./tmp/src/main/scala/'+name+'/')
  os.system('mv ./tmp/core ./tmp/src/main/scala/' + name + '/')
  os.system('mv ./tmp/api ./tmp/src/main/scala/' + name + '/')
  os.system('scp -r '+util_path+' ./tmp/src/main/scala/' + name + '/')
  os.system('scp -r ./src/util ./tmp/src/main/scala/' + name + '/')
  f_obj = open("./tmp/src/main/scala/"+name+"/util/csvLogger.scala", "r")
  contents = f_obj.read().replace("<replace_name>", name + ".logger")
  f_obj.close()
  f_obj = open("./tmp/src/main/scala/"+name+"/util/csvLogger.scala", "w")
  f_obj.write(contents)
  f_obj.close()

  os.system('scp ./src/build.sbt ./tmp/')
  f_obj = open("./tmp/build.sbt", "r")
  contents = f_obj.read().replace("<replace_name>", "\""+name+"\"")
  f_obj.close()
  f_obj = open("./tmp/build.sbt", "w")
  f_obj.write(contents)
  f_obj.close()

  os.system('scp ./src/wrapper.scala ./tmp/src/main/scala/')
  f_obj = open("./tmp/src/main/scala/wrapper.scala", "r")
  contents = f_obj.read().replace("<replace_name>", name)
  f_obj.close()
  f_obj = open("./tmp/src/main/scala/wrapper.scala", "w")
  f_obj.write(contents)
  f_obj.close()

  os.system('mv ./tmp/util.scala ./tmp/src/main/scala/' + name + '/')

  os.system('java -jar ./driver-assembly-0.0.3.jar ./tmp/src/main/scala/' + name + '/ ' + st_path + ' ./tmp/preamble.txt false true')

  f_obj = open("./tmp/src/main/scala/" + name + "/driver.scala", "r")
  contents = f_obj.read().replace("import driver.util.{logger, csvLogger}", "import "+name+".logger._")
  contents = "package "+name+"\nimport "+name+".model._\nimport "+name+".core._\nimport "+name+".api._\n" + contents
  f_obj.close()
  f_obj = open("./tmp/src/main/scala/" + name + "/driver.scala", "w")
  f_obj.write(contents)
  f_obj.close()

  # os.system('mv ./tmp/driver.scala ./tmp/src/main/scala/' + name + '/')
  # os.system('mv ./tmp/wrapper.scala ./tmp/src/main/scala/' + name + '/')
  # os.system('mv ./tmp/util.scala ./tmp/src/main/scala/' + name + '/')
  os.system('scp -r ./src/project ./tmp/')
  os.system('mkdir ./tmp/logs/')
  os.system('mkdir ./tmp/debug/')
  os.system('mkdir ./tmp/debug/S_' + name + '/')

  # shutil.make_archive('./out/' + name + '_driver', 'zip', './tmp/')
  shutil.make_archive(dirname+'/'+name+'_driver', 'zip', './tmp/')
  
  # os.system('rm -r ./tmp/.openapi-generator/')
  # os.system('rm ./tmp/.openapi-generator-ignore')
  # os.system('rm ./tmp/build.sbt')
  # os.system('rm ./tmp/README.md')
  # os.system('rm -r ./tmp/project/')
  # os.system('mv ./tmp/src/main/scala/org/openapitools/client/api/ ./tmp')
  # os.system('mkdir ./tmp/api')
  # os.system('cp '+util_path+' ./tmp/')
  # apiFiles = glob.glob('./tmp/api/*')
  # for f in apiFiles:
  #     f_obj = open(f, "r")
  #     contents = f_obj.read().replace("package org.openapitools.client.api", "package examples."+name+".api").replace("import org.openapitools.client", "import examples."+name)
  #     contents = contents.replace("import examples."+name+".model.AnyType\n", "")
  #     f_obj.close()
  #     f_obj = open(f, "w")
  #     f_obj.write(contents)
  # os.system('mv ./tmp/src/main/scala/org/openapitools/client/core/ ./tmp')
  # os.system('mkdir ./tmp/core')
  # coreFiles = glob.glob('./tmp/core/*')
  # for f in coreFiles:
  #     f_obj = open(f, "r")
  #     contents = f_obj.read().replace("package org.openapitools.client.core", "package examples."+name+".core").replace("import org.openapitools.client", "import examples."+name)
  #     f_obj.close()
  #     f_obj = open(f, "w")
  #     f_obj.write(contents)
  # os.system('mv ./tmp/src/main/scala/org/openapitools/client/model/ ./tmp')
  # os.system('mkdir ./tmp/model')
  # coreFiles = glob.glob('./tmp/core/*')
  # for f in coreFiles:
  #     f_obj = open(f, "r")
  #     contents = f_obj.read().replace("package org.openapitools.client.model", "package examples."+name+".model").replace("import org.openapitools.client", "import examples."+name)
  #     f_obj.close()
  #     f_obj = open(f, "w")
  #     f_obj.write(contents)
  # os.system('rm -r ./tmp/src/')
  # os.system('java -jar ./driver-assembly-0.0.3.jar ./tmp/ '+st_path+' ./tmp/preamble.txt false true')
  # shutil.make_archive(dirname+'/'+name+'driver', 'zip', './tmp/')


if __name__ == "__main__":
  root = Tk()
  root.title("COTS")

  root.geometry("900x700")
    
  # B = Button(root, text ="Select directory of invoices", command = getDirname)
  # B.place(relx=0.5, rely=0.5, anchor=CENTER)

  open_button = tk.Button(root, text="Select .st File", command=open_st_file_dialog)
  open_button.place(relx=0.5, rely=0.1, anchor=CENTER)

  selected_file_label = tk.Label(root, text="Step 1: Select a specification file.")
  selected_file_label.place(relx=0.5, rely=0.15, anchor=CENTER)

  open_button_2 = tk.Button(root, text="Select OpenAPI File", command=open_openapi_file_dialog)
  open_button_2.place(relx=0.5, rely=0.3, anchor=CENTER)

  selected_file_label_2 = tk.Label(root, text="Step 2: Select the OpenAPI schema file.")
  selected_file_label_2.place(relx=0.5, rely=0.35, anchor=CENTER)

  open_button_3 = tk.Button(root, text="Select Util File", command=open_util_file_dialog)
  open_button_3.place(relx=0.5, rely=0.5, anchor=CENTER)

  selected_file_label_3 = tk.Label(root, text="Step 3: Select the Util file.")
  selected_file_label_3.place(relx=0.5, rely=0.55, anchor=CENTER)

  T = Text(root, height = 1, width = 20)
  l = Label(root, text = "Step 4: Write the respective package name")
  l.place(relx=0.5, rely=0.65, anchor=CENTER)
  T.place(relx=0.5, rely=0.7, anchor=CENTER)
  

  open_button_4 = tk.Button(root, text="Select Directory", command=getDirname)
  open_button_4.place(relx=0.5, rely=0.8, anchor=CENTER)

  selected_file_label_4 = tk.Label(root, text="Step 5: Select the directory where to generate the files.")
  selected_file_label_4.place(relx=0.5, rely=0.85, anchor=CENTER)

  generate_button = tk.Button(root, text="Generate test driver", command=generate_driver)
  generate_button.place(relx=0.5, rely=0.95, anchor=CENTER)

  # file_text = tk.Text(root, wrap=tk.WORD, height=10, width=40)
  # file_text.place(relx=0.5, rely=0.5, anchor=CENTER)

  # T = Text(root, height = 5, width = 52)
 
  # label1=Label(root, text="")
  # label1.place(relx=0.5, rely=0.63, anchor=CENTER)
  # label2=Label(root, text="")
  # label2.place(relx=0.5, rely=0.73, anchor=CENTER)

  root.mainloop()