import custom.WriteFile as WriteFile

//append to file
String file_name = "Data Files//Organizations.txt"
WriteFile data = new WriteFile(file_name, true)
data.WriteToFile("This-is-a-line-of-text")
println("One record written to file...")


//overwrite file
//String file_name =  "//Users//frankpage//Katalon Studio//SecureGive Framework//Data Files//Organizations.txt"
//WriteFile data = new WriteFile(file_name)
data.WriteToFile("This-is-a-line-of-text3")
println("One record written to file...")

//surround with try/catch
try{
	data.WriteToFile("This-is-a-line-of-text3")
	println("One record written to file...")
}
catch (IOException e){
	System.out.println( e.getMessage())
}

File file=new File("Data Files//Organizations.txt")
println file.getText()
def OrgNames = file.getText()


//turn text file into List
List Orgs = OrgNames.split("\n")

System.out.println(Orgs.size())

for (int index = 0; index < Orgs.size(); index++) {
	System.out.println(Orgs[index])
}




