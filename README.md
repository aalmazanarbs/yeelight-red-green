# Yeelight Red Green IntelliJ plugin

Yeelight integration with IntelliJ to show different light colors during test.

When the tests start, the Yeelight bulb goes white and when the tests finish, it will go 
green if tests passes or red if fails

## Run in local

1. Set up Yeelight device in [LAN Control mode](https://www.yeelight.com/faqs/lan_control "Yeelight") to allow direct connecting to the device ip from the 
   same network. Get your Yeelight device network IP.
   
2. Open this project with IntelliJ and run a new IntelliJ instance by running Gradle task intellij -> runIde
   This will run a new instance of IntelliJ with the plugin installed.
   
3. Configure the IP of your Yeelight device in `File | Settings | Tools | Yeelight Red Green Plugin Settings`
   
4. Crate a test (i.e junit @Test) and run it. The light of the Yeelight device must change.
   
## Distribute
https://jetbrains.org/intellij/sdk/docs/tutorials/build_system/deployment.html 