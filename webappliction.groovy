node{
  stage('My first stage') {
    echo 'Hello world!'
  }

  stage('My second stage') {
    def message = 'Hello world'

    echo 'Greeting: ${message}'
    echo "Greeting: ${message}"
  }

  def stageNum = 'third'

  stage("My ${stageNum} stage") {
    echo 'Workspace:'
    sh(script: 'ls -la')
  }
}
