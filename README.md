# automation-tests
Automation setup for running cucumber tests

*How to run*
1. Import the project as Maven
2. Setup a maven or junit configuration with below parameters and run
  a. targetServer="www.phptravels.net/login"
  b. browserProfile=chrome-windows-64bit-local
  c. webdriver.chrome.driver="C:/Users/admin/Documents/chromedriver-2.35.exe"
  d. cucumber.options="--tags @complete"
  
Refer env.conf & webdriver.conf files for more info
