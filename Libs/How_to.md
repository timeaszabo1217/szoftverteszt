Ctrl + Alt + Shift + S (Project Structure, than Libraries)
Add Java library
Add the .jar files to Client and Server too, than Apply
Tick it in Client and Server Modules too, than Apply
(javafx jars is in the openjfx../javafx-sdk-23/lib folder)
Its in windows mode, you can download Linux too in browser

Create two Java Application Runner, than Edit Configuration
Add JDK (mine is 19) and -cp is Client and Server
Client: Main class is Main from the list, that is in the Client folders src
Server: Main class is Server from Server folders src

Click on Modify options and Add VM options in Client and Server too
Into VM options, paste this: --module-path "tools/jar_files_to_library/openjfx-23_windows-x64_bin-sdk/javafx-sdk-23/lib" --add-modules=javafx.controls,javafx.fxml,javafx.base,javafx.media,javafx.graphics
(I did it whith absolute path, which begins with "C\\:"), than Apply

To run the Application, you have to run Server app first, than Main (Client) app
And tada, you can play now

I did some writing in the code, because some of that was outdated, I commented fixed to this places

Szabó Tímea 2024