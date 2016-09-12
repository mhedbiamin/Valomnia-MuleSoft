Valomnia ConnectorDemo
==================================



###
#Pre-requisites


* Anypoint Studio with Mule ESB 3.8 Runtime.

* Anypoint Valomnia v1.0.0

* Valomnia account





###Preparation

1.Import this DEMO in Anypoint Studio going to File → Import…​ → Anypoint Studio Project from External Localtion, select the demo project root and choose as server runtime Mule Server 3.8.x EE.

2.Once imported, in src/main/app you will find mule-app.properties file, this contains all the placeholders for the required properties to make the DEMO work. Open it. It will be like the following:

valomnia.username=

valomnia.password=

valomnia.baseurl=

Fill each property with the required value.

3.In Anypoint Studio, Right click in the project folder → Run As → Mule Application.

4.If the Mule App is deployed correctly, you can start playing with this app:



#### Valomnia-operations-demo :

* Run the demo project.
* In web browser visit http://localhost:8081/Valomnia to view the demo page. The page displays the operations  
to invoke  defined by the flows.

While the demo project is
 up and running  you can click botton  to view the output of individual flows.

You can also directly visit the below URL's to view the output of individual flows.

* Get Items : http://localhost:8081/Valomnia/FindItems
* Save Or Update Item : http://localhost:8081/Valomnia/SaveOrUpdateItem

SUMMARY
-------

Congratulations! The demo presents only a limited list of operations to play with, refer to the connector user manual for all the operations supported and further possibilities.












