echo off
echo Instalando Papel Prenshija
md output

rem registrar fuentes
cd fontreg
FontReg.exe /copy
cd.. 

rem creando el accesso directo
if exist "%userprofile%\Escritorio" (xxmklink.exe "%userprofile%\Escritorio\Papel Prenshija" "%programfiles%\Papel Prenshija\papelprenshija.exe")
if exist "%userprofile%\Desktop" (xxmklink.exe "%userprofile%\Desktop\Papel Prenshija" "%programfiles%\Papel Prenshija\papelprenshija.exe")

rem borrando tuti
rd /s /q fontreg
del xxmklink.exe

del installer.bat