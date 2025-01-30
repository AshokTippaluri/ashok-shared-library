node {
    stage('Execute Groovy Script') {
        try {
            def message = "Hello Ashok, how are you?" // Defining variable
            println message // Calling variable

            // Print Jenkins version (Requires script approval)
            try {
                println "Jenkins Version: " + Jenkins.instance.getVersion()
            } catch (Exception e) {
                println "Access denied to Jenkins.instance.getVersion() due to script security."
            }

            // Variable assignments
            def x = 1
            println x

            x = new java.util.Date()
            println x

            x = false
            println x

            // List operations
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

            boolean contain = list.contains("apple")
            boolean y = "dog" in list
            println y

            boolean allPresent = list.containsAll(['apple', 'dog'])
            println allPresent

            list.sort()
            def z = list.sort(false)
            println z

        } catch (Exception e) {
            println "Error encountered: ${e.message}"
        }
    }
}
