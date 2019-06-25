# Sonar Custom Rule

### Test the plugin:
 - We can build the plugin with maven 
    + `mvn clean install`

 - After built successfully, copy and place it into `sonar-path`/extensions/plugins. @Note you need to install SonarQube or use docker; In case of using docker, you can use the command to copy the plugin into docker container where sonar plugin folder locates
    + `docker cp custom-rule-1.0-SNAPSHOT.jar [container_id]:/opt/sonarqube/extensions/plugins/custom-rule-1.0-SNAPSHOT.jar`
    
    **Example:** 
    + `docker cp custom-rule-1.0-SNAPSHOT.jar 3d76d14d0de6:/opt/sonarqube/extensions/plugins/custom-rule-1.0-SNAPSHOT.jar`

 - (Re)start SonarQube server (for docker: docker restart [container_id]), log as admin and navigate to the Rules tab. From there, under the language section, select "Java", and then your plugin repository (Ex: "Mulodo Repository") under the repository section. Your rule should now be visible (with all the other sample rules). 

 - Also to make the rule effective, you may need to activate the rule by using this way:
   * On the menu bar: 'Quality Profile'
   * Then on the right of the top, click 'Create' (You can skip this step if already have your own)
   * After having a new profile, click on the setting button and set it as default
   * Then click 'Activate More' and select plugin to activate

 - If you don't have a permissions to access Quality Profiles, try this:
   * On the menu bar: 'Administration' -> 'Security' -> 'Global Permissions'
   * Then grant 'Quality Gates', 'Quality Profiles' access to the current user by check in the checkbox
 
 - Eventually, if everything is ok, we will see your plugin works properly.


### References:
- https://github.com/mulodo-vietnam/vcs-inspection/wiki/sonar-custom-rule-wiki
