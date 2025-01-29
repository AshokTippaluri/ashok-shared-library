node{
  def message = 'Hello world'
  stage('My first stage') {
    echo "${message}"
  }

  stage('My second stage') {
    // def message = 'Hello world'

    // echo 'Greeting: ${message}'
    echo "Greeting: ${message}"
  }

  def stageNum = 'third'

  stage("My ${stageNum} stage") {
    echo 'Workspace:'
    echo "Greeting: ${message}"
    sh(script: 'ls -la')
  }
}
