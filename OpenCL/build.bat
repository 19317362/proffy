set WINDOWS_SDK_PATH=C:\Program Files\Microsoft SDKs\Windows\v6.1
cmd.exe /E:ON /V:ON /C build64.bat
test.exe > output.txt
pause
