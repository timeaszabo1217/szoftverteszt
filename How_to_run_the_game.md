Video: https://youtu.be/dUxtx0L6a8Y

Use Oracle OpenJDK, because you have to use javafx, which is just in that.

Open Project Structure (Ctrl + Alt + Shift + S)
In Libraries:
Add Java library to Client and Server
Add the .jar files to Client and Server too, than Apply
In Dependencies:
Tick it in Client and Server Modules too, than Apply
(javafx jars is in the openjfx../javafx-sdk-23/lib folder)
Its in windows mode, you can download Linux too in browser
In Sources:
src folders are Sources root, resources folders are Resources root

Create two Java Application Runner, than Edit Configuration
Add JDK (mine is 23, it works with 19 too) and -cp is Client and Server
Client: Main class is Main from the list, that is in the Client folders src
Server: Main class is server.Server from Server folders src
Click on Modify options and Add VM options in Client and Server too
Search your path to your .jar files and add it to the VM --module-path
Into VM options: --module-path <your_path_to_libs> --add-modules=javafx.controls,javafx.fxml,javafx.base,javafx.media,javafx.graphics
(I did it with absolute path, which begins with "C\\:"), than Apply

Client needs a longer VM (in IntellIJ Idea):
--module-path <your_path_to_libs> --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media --add-opens java.desktop/java.beans=ALL-UNNAMED "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\lib\idea_rt.jar=55654:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\out\production\Client;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\commons-codec-1.9.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx-graphics-23-linux.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\unirest-java-1.8.0.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx.graphics.jar;C:\Users\timea\OneDrive\Documents\GitHub\bravo\Libs\httpasyncclient-4.1.3.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\httpcore-4.4.6.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx.media.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\gson-2.8.0.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\httpmime-4.5.3.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\slf4j-api-1.7.25.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx.web.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\json-20160212.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\httpclient-4.5.3.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\httpcore-nio-4.4.6.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx-base-23-linux.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx.fxml.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx.swing.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\commons-logging-1.2.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx-swt.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx.base.jar;C:\Users\<your_name>\OneDrive\Documents\GitHub\bravo\Libs\javafx.controls.jar Main
I added <> tags to know that where you have to write in.

To run the Application, you have to run Server app first, than Main (Client) app
And tada, you can play now.

I did some writing in the code, because some of that was outdated, I commented fixed to this places.
For example: in Rest.java 160. and 183. row 'getBody()' to 'body()'.

Tímea Szabó 2024