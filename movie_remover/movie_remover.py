#! /usr/bin/env python3

from os import  (F_OK, W_OK, access, getcwd, makedirs,
                 mkdir, remove, rmdir,scandir,fsdecode,path,listdir,name as os_name)
from sys import getfilesystemencoding
from collections import deque
from shutil import move
from logging import error, info
from re import I, compile

class PathNotFoundError(FileNotFoundError):
    def __init__(self, path) -> None:
        super().__init__()
        self.path = path

    def __str__(self) -> str:
        return f"The provided path :{self.path} with does not exist "

# def validate_path_name(path):
#     return False if not compile(r"[_-a-zA-Z0-9/\]+").match(path) else True

def resolve_os_encoding(path):
    return fsdecode(path) if getfilesystemencoding() != "utf-8" else path


def create_folder_path(destination_path,folder_name):
    try:
        destination_folder_path = path.join(
                destination_path,folder_name)
        makedirs(destination_folder_path)
        return destination_folder_path
    except:
        raise IOError

def create_destination_folder(folder_name):
    destination_path  = resolve_os_encoding(getcwd())
    try:
        if not access(destination_path,F_OK):
            raise PathNotFoundError(destination_path)
        if not access(destination_path,W_OK):
            raise PermissionError()
    except PathNotFoundError :
        create_folder_path(destination_path,folder_name)
    except PermissionError as permission_denied:
        raise permission_denied
    else:
        try:
            destination_folder_path = path.join(
                destination_path,folder_name)
            if (not path.exists(destination_folder_path) 
                or not path.isdir(destination_folder_path)):
                mkdir(destination_folder_path)
            if not path.isdir(destination_path):
                raise FileNotFoundError()
            return destination_folder_path
        except IOError as err:
            raise err
        

def move_files_to_path(destination_path, file_path):
    file_name = path.basename(file_path)
    try:
        if not path.isdir(destination_path):
            raise FileNotFoundError(destination_path)
        move(file_path,destination_path)
        info(f"moved the file : "+
            f"{file_name} into the folder in {destination_path} ")
    except FileNotFoundError as file_not_found :
        error(f"The destination folder : {file_not_found.args[0]} was not found.")
        raise IOError from file_not_found
    except IOError as err:
        error("error occured while trying to "+
                f"move file : {file_name} to  {destination_path} ")
        raise err
        

def get_file_extension(path):
    return path.splitext(path)[-1]

def get_root_dir():
    return "/" if os_name == "postfix" else "C:\\"


def retrieve_filtered(filepaths):

    filtered = []
    expression = r"""((\s)?copy( \d*)?.[a-zA-Z]{1,4}([0-9]*))$|
    [0-9A-Fa-f]*.[a-zA-Z]{1,4} copy( \d*)?.[a-zA-Z]{1,4}$|
    [0-9a-zA-Z]*.[a-zA-Z]{1,4} copy( \d*)?.[a-zA-Z]{1,4}$|
    (\w+(\s|_|-)*)*(.[a-zA-Z]{1,4})? copy( \d*)?.[a-zA-Z]{1,4}$|
    (\w+(\s|_|-)*)*(_|\s)(\(\d+\)|\d+)\.[a-zA-Z]{1,4}$"""
    for filepath in filepaths:
        filename = path.basename(filepath)
        if  compile(expression,I).search(filename) :
            filtered.append(filepath)
    return filtered
    

def retreive_all_files_path():
    filepaths = []
    try:
        # get the current working directory 
        root_path = resolve_os_encoding(getcwd())
        
        info("Queing directories / sub-directories"
                +" path for file path processing")
        # retrieve all the available files names and path
        queue = deque()
        queue.append(root_path)
        # open all sub-directories in current folder by adding them 
        while queue:
            curr_dir_path = queue.popleft()
            with scandir(curr_dir_path) as dir_itr:
                for entry in dir_itr:
                    if entry.is_file():
                        filepaths.append(
                            resolve_os_encoding(entry.path))
                        continue
                    elif entry.is_dir():
                        queue.append(
                            resolve_os_encoding(entry.path))
    except OSError as err:
        error("Queing directories / sub-directories"+
                " path for file path processing")
        raise err
    else:
        return filepaths



def  list_files_destination(folder_name=''):
    destination_folder_path = path.join(
                resolve_os_encoding(getcwd()),folder_name)
    files = listdir(destination_folder_path)
    for file in files:
        print(f"\t> {file}")
    print("++++++++++++++++++ done ++++++++++++++++++++",end="\n")



def delete_all_files_in_folder(folder_name):
    destination_folder_path = path.join(
                resolve_os_encoding(getcwd()),folder_name)
    files = listdir(destination_folder_path)
    for file in files:
        info(f"deleting file : {file} ")
        remove(path.join(destination_folder_path,file))
    rmdir(destination_folder_path)


def main(destination_folder_name):
    try:
        filepaths =  retreive_all_files_path()

        if len(filepaths):
            filtered_filepaths = retrieve_filtered(filepaths)
            # move the filter_filepaths into the destination folder
            destination_folder_path = create_destination_folder(
                                                        destination_folder_name)
            for file_path in filtered_filepaths:
                move_files_to_path(destination_folder_path,file_path)
        
    except PathNotFoundError as path_not_found:
        print(path_not_found.strerror)
    except FileNotFoundError as file_not_found:
        print(file_not_found.strerror)
    except IOError as io_error:
        print(io_error.strerror)    
    finally:
        print("Here are the files moved to folder name "+
                            f":{destination_folder_name}")
        list_files_destination(destination_folder_name)
        answer = input("Choose the [Y/y] or any other character "+
                "to delete listed moved [NOTE] file will probably "
                +f"file into the {destination_folder_name} >>")
        if answer == "Y" or  answer == "y":
            try:
                delete_all_files_in_folder(destination_folder_name)
                print("The duplicate files have been successfully deleted !!!")
            except IOError  as err:
                raise err
        else:
            print("Did not delete all listed file ,"+
                            " you should probably delete yourself.")
        
        
    

if __name__ == "__main__":
    main("test")
