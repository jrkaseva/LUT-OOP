#####################################################
#Author: Joakim Kaseva                              #
#Automated menu maker in Finnish                    #
#                                                   #
#                                                   #
#                                                   #
#                                                   #
#                                                   #
#####################################################
import sys

#Gets size of wanted menu
def makemenu():
    lista = []
    print("Tämä ohjelma luo valmispohjan menupohjaiselle Java-ohjelmalle.")
    num = input("Anna valikon koko: ")
    try:
        num = int(num)
    except ValueError:
        print("Antamasi syöte '" + num + "' ei ollut numero.")
        sys.exit(0)
    getmenu(num, lista)
    retmenu(lista)

#Gets options for the menu
def getmenu(num, arr):
    for i in range(1, num + 1):
        arr.append(input(str(i) + ". toiminto: "))

#Creates the .py file as per requested
def retmenu(arr):
    kirjoitukset = []
    file = None
    while file is None:
        fN = input("Anna ohjelman nimi: ")
        fN2 = muunna(fN).capitalize() + ".java"
        try:
            file = open(fN2, "x", encoding="utf-8")
        except OSError:
            print("On jo tiedosto nimeltään '" + fN2 + "'. Yritä uudestaan.")
    uusiMain(kirjoitukset, fN)
    uusimenu(kirjoitukset, arr)
    uusiexecute(kirjoitukset, arr)
    uudetAliOhjelmat(kirjoitukset, arr)
    for i in kirjoitukset:
        file.write(i)
    file.close()
    print("Tiedosto '" + fN + "' luotu. Muista täyttää ja muokata ohjelma valmiiksi loppuun!")

#The writing for the "def main()" in the .py file
def uusiMain(arr, fileName):
    kuvaus = input("Mitä ohjelma tekee?(Tämä ohjelma...): ")
    arr.append("import java.util.Scanner;\n")
    arr.append("/**\n*Author: Joakim Kaseva\n*/\n")
    arr.append("public class " + fileName.capitalize() + " {\n\t")
    arr.append("public static final Scanner sc = new Scanner(System.in);\n\t")
    arr.append("public static void main(String[] args){\n\t\t")
    arr.append("System.out.println(\"" + kuvaus + "\");\n\t\t")
    arr.append("int choice = menu();\n\t\t")
    arr.append("while (true){\n\t\t\t")
    arr.append("if (choice == 0) break;\n\t\t\t")
    arr.append("execute(choice);\n\t\t\t")
    arr.append("choice = menu();\n\t\t")
    arr.append("}\n\t\t")
    lopetus = "Kiitos ohjelman käytöstä."
    arr.append("System.out.println(\"" + lopetus + "\");\n\t")
    arr.append("}\n\n\t")

#The writing for the "def menu()" - aka the menu
def uusimenu(arr, arr2):
    arr.append("public static int menu(){\n\t\t")
    arr.append("String[] options = new String[] {")
    for i in range(0, len(arr2) - 1):
        arr.append("\"" + arr2[i] + "\", ")
    arr.append("\"" + arr2[-1] + "\"};\n\t\t")
    arr.append("System.out.println(\"Käytettävissä olevat toiminnot:\");\n\t\t")
    arr.append("for (int i = 1; i < options.length + 1; i++){\n\t\t\t")
    arr.append("System.out.println(String.format(\"%d. %s\", i, options[i - 1]));}\n\t\t")
    arr.append("System.out.println(\"0) Lopeta\");\n\t\t")
    arr.append("System.out.println(\"Valintasi: \");")
    arr.append("int choice = sc.nextInt();\n\t\t")
    arr.append("sc.nextLine();\n\t\t")
    arr.append("return choice;\n\t")
    arr.append("}\n\n\t")

#The writing for the "def execute" - aka which option has been selected
def uusiexecute(arr, toiminnot):
    arr.append("public static void execute(int number){\n\t\t")
    count = 1
    for i in toiminnot:
        if count == 1:
            arr.append("if (number == " + str(count) + "){\n\t\t\t")
        else:
            arr.append("else if (number == " + str(count) + "){\n\t\t\t")
        i = muunna(i)
        arr.append(i + "();\n\t\t")
        arr.append("}\n\t\t")
        toiminnot[count - 1] = i
        count += 1
    arr.append("else System.out.println(\"Valintaa ei tunnistettu, yritä uudestaan.\");\n\t")
    arr.append("}\n\n\t")

#Changes the options into lowercase and code friendly
def muunna(mjono):
    mjono = ''.join(ch for ch in mjono if ch.isalnum())
    mjono = mjono.lower()
    mjono = mjono.replace("ä", "a")
    mjono = mjono.replace("ö", "o")
    if mjono[0:1:1].isdigit():
        mjono = "_" + mjono
    return mjono

#Creates the "def *" where * are the options
def uudetAliOhjelmat(arr, toiminnot):
    for i in toiminnot:
        arr.append("public static int " + i + "(){\n\t\t")
        arr.append("// Fill in\n\t\t")
        arr.append("return 0;\n\t")
        arr.append("}\n\n\t")
    arr.append("\n}")

makemenu()
