def message = "Hello ashok how are you" // defining variable 

println message // calling variable 

println Jenkins.instance.getVersion() // jenkins version

def x =1
println x

x = new java.util.Date()
println x

x = false
println x


def list = []
println list
list = ["apple", "cat"]

println list

list.add("dog")

println list

list << "tiger"

println list


list.addAll(["pig", "rat"])
println list

list.remove("cat")
println list

list = list - "rat"

println list

list.each { println "animal : $it" }

list.eachWithIndex { it, i -> println "$i: $it"}


contain = list.contains( "apple" )

y = "dog" in list

println y


list.containsAll(['apple','dog'])


list.sort()

z = list.sort( false )

println z
