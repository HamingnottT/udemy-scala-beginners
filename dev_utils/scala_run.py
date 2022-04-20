import os

# main menu text
def info():
    print("\nThis program will help run individual scala files fast.\n")
    print("Please enter the comment below and this program will handle the rest:")
    print("\nsyntax:")
    print("bash: $ scala <optional: folder or path>/test.scala\ncmd: > scala <optional: folder or path>\\test.scala\n")


# current directory
def run_scala_current_dir():
    print("\n~ current directory option selected ~\n")
    info()
    comment = input("scala ")
    os.system("cd ..")
    print("\n/!\\ running program. . . /!\\\n")
    os.system(f"scala {comment}")
    print("\n/!\\ end of program. . . /!\\\n")


# shortcut to src/main/scala directory from sbt
def run_scala_src():
    print("\n~ src/main/scala directory option selected ~\n")
    info()
    comment = input("scala src/main/scala/")
    os.system("cd ..")
    print("\n/!\\ running program. . . /!\\\n")
    os.system(f"scala src/main/scala/{comment}")
    print("\n/!\\ end of program. . . /!\\")


# menu options
def options():
    def main_options():
        print("Input one of these options:\n\n"
                    "1 = Run from current directory \n"
                    "2 = Run from src/main/scala (if using sbt) \n"
                    "0 = Cancel & Exit \n")

    main_options()
    option = int(input("input here: "))

    while option != 0:
        if option == 1:
            run_scala_current_dir()    
            pass
        elif option == 2:
            run_scala_src()
            pass
        else:
            print("\nInvalid response, please try again.\n")

        print("\n")    
        main_options()
        option = int(input("Input here: "))


# adding for script scalability
def main():
    options()
    pass


if __name__ == '__main__':
    main()
