@echo off
echo ****************package sjb*********************

%~d0
cd %~dp0
echo -----------------------start-------------------------
call mvn clean package -Dmaven.test.skip=true
echo -----------------------complete----------------------
echo ****************package complete*********************
pause