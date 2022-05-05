def call(String buildStatus = 'STARTED') {
  // build status of null means successful
  //This is the condition which we are checking weather buildStatus is SUCCESSFULL or not.
 //This line updated to show the Eclipse with GitHub demo
  buildStatus =  buildStatus ?: 'SUCCESS'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESS') {
    color = 'GREEN'
    colorCode = '#00FF00'
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }

  // Calling the slackSend function to Send notifications.
  slackSend (color: colorCode, message: summary)
}
