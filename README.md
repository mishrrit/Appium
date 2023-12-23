# Appium
Appium- Mobile WebTesting Tool


## Setup APPIUM

### Pre-Requisite
1. JDK 1.8
2. Install Android Studio
 - Download Android studio
 - Install Android SDK
 - Install Android API (Emulators)
 - Set the env path variable
 	- JAVA_HOME
    	- ANDROID_HOME
    	- PATH
    	  	- JRE
    		- Tools
    		- Tools/bin
    		- Platform-tools
3. Open Your CMD:
	- For getting glist of packages, Run this command: sdkmanager --list
	- For Inspecting element, Run this command: uiautomatorviewer 
			
4. Open AVD Manager:
	- Create a device
	- launch it.
5. Running Appium Desktop 
  - Follow the below step if you want to download the Windows installation file
	   - Download Appium Desktop for Windows
	   - Install it
	   - Run it
	   - Configure Appium desktop with 127.0.0.1:4723 under Advanced
	   - Appium Server is up and running

 - Follow the path if you want to install Appium server through the command line(npm should be preinstalled)
   - Open the command prompt
   - Execute the below command: npm install -g appium-server
   - Run the below command for running appium server: appium
   - Execute the below command to get the list of the appium drivers: appium driver list
   - Execute the below command to install appium plugins: appium driver install <plugin name> 
	 - for ex. appium driver install uiautomator2


## Blog:
 https://www.devonblog.com/test-automation/appium-architecture-an-overview/

### Just for Reference
https://stackoverflow.com/questions/76077033/how-to-pass-the-com-android-permissioncontroller-permission-ui-reviewpermissions

## Common issues:
    app incompatibility - restart ide
    appium server not starting in the console - upgrade appium java client to latest i.e. 8.5.0


    appium-inspector for inspecting elements
    https://github.com/appium/appium-inspector/releases
