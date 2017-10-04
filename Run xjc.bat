@echo off
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.6.0_25
set PROJ_HOME=C:\Users\Gagan\Workspace\JavaPractice\JAXBPractice
path=%JAVA_HOME%\bin;
cd=%PROJ_HOME%\XSD
xjc -d %PROJ_HOME%/src -p gagan.practice.jaxb.beans.generated CustomerOrder.xsd
pause