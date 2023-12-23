# Appium
Appium- Mobile WebTesting Tool


# Setup APPIUM
#################

## Pre-Requisite
1. JDK 1.8
2. Install Android Studio
	a. Download android studio
	b. Install Android SDK
	c. Install Android API (Emulators)
	d. Set the env path variable
		1.JAVA_HOME
		2.ANDROID_HOME
		3. PATH
			a. JRE
			b. Tools
			c. Tools/bin
			d. Platform-tools
3. Open Your CMD:
		a. Run this command: sdkmanager --list
			this will give you the list of packages
		b. Run this command: uiautomatorviewer 
			this will open up a window where we can inspect element
4. Open AVD Manager:
	a. Create a device
	b. launch it.
5. Running Appium Desktop 
	Follow the below step if you want to download the windows installation file
	a. Download Appium Desktop for Windows
	b. Install it
	c. Run it
	d. Configure Appium desktop with 127.0.0.1:4723 under Advanced
	e. Appium Server is up and running

	Follow the path if you want to install apium server throuh command line(npm should be preinstalled)
	a.Open the command prompt
	b.Execute the below command : npm install -g appium-server
	c.Run the below command for running appium server: appium
	d.Execute the below command to get the list of the appium drivers: appium driver list
	e.Execute the below command to install appium plugins : appium driver install <plugin name> 
	 for ex. appium driver install uiautomator2


# Blog:
 https://www.devonblog.com/test-automation/appium-architecture-an-overview/

# Just for Reference
https://stackoverflow.com/questions/76077033/how-to-pass-the-com-android-permissioncontroller-permission-ui-reviewpermissions

# common issues:
    app incompatability - restart ide
    appium server not starting in the console - upgrade appium java client to latest i.e. 8.5.0


    appium-inspector for inspecting elements
    https://github.com/appium/appium-inspector/releases