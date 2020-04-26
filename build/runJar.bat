@echo off
set JAVA_HOME=C:\Users\Familia\Documents\Daniel\eclipse\jre
REM set JAVA_HOME=C:\Users\BRDPG1\Documents\Programas\jdk\jdk-11.0.6
REM set JAVA_HOME=%CD%\jre

set PATH_TO_JAVAFX=C:\Users\Familia\Documents\Daniel\eclipse\java-libs\javafx-sdk\lib
REM set PATH_TO_JAVAFX=%APP_CURRENT_PATH%\javafx-sdk\lib
REM set PATH_TO_JAVAFX=%CD%\javafx-sdk\lib

set PATH=%JAVA_HOME%\bin;%PATH%

where java
java -version

set /p argument="USAGE: runJar.bat [chess|javafx-demo]: "

if "%argument%" == "chess"       (java -cp javafxdemo.jar s16.ChessSystem.Application.Program)
if "%argument%" == "javafx-demo" (java --module-path %PATH_TO_JAVAFX% --add-modules javafx.controls,javafx.fxml -cp javafxdemo.jar s23.WorkshopJavaFXJdbc.application.Main) else (echo "USAGE: runJar.bat [chess|javafx]")
                        

REM Para executar a aplicacao como software no cliente
REM java --module-path %PATH_TO_JAVAFX% --add-modules javafx.controls,javafx.fxml -cp javafxdemo.jar s23.WorkshopJavaFXJdbc.application.Main

pause

