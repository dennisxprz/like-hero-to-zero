@echo off
REM Stelle sicher, dass dieser Pfad zu deiner derbytools-*.jar-Datei passt:
set DERBY_TOOLS_JAR=%USERPROFILE%\.m2\repository\org\apache\derby\derbytools\10.15.2.0\derbytools-10.15.2.0.jar

REM Prüfen, ob die Datei existiert
if not exist "%DERBY_TOOLS_JAR%" (
    echo ❌ Tools JAR nicht gefunden: %DERBY_TOOLS_JAR%
    pause
    exit /b
)

REM Starte Derby IJ
echo ✅ Starte Derby ij-Konsole...
echo --------------------------------------------------
java -cp "%DERBY_TOOLS_JAR%" org.apache.derby.tools.ij

REM Fenster offen halten
echo --------------------------------------------------
echo Vorgang abgeschlossen. Drücke eine Taste zum Schließen...
pause
