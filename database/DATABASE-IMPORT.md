## 📥 Datenbank-Import

Um die MySQL-Datenbank mit den CO₂-Emissionsdaten zu befüllen, führen Sie bitte folgende Schritte aus:

### Voraussetzungen
- MySQL Server ist installiert und läuft
- Datenbank `co2db` ist bereits angelegt (z.B. via MySQL Workbench oder CLI)

### Schritt 1: Wechseln Sie in das Verzeichnis mit der Dump-Datei
```bash
cd pfad/zum/projekt/database

### Schritt 2: Importieren Sie den Dump in die Datenbank
mysql -u root -p co2db < emission_data_dump.sql

root ist der MySQL-Benutzername (ggf. anpassen)

co2db ist der Datenbankname (ggf. anpassen)

-p bedeutet, dass Sie zur Eingabe Ihres MySQL-Passworts aufgefordert werden.

Das Passwort ist individuell und wird bei der MySQL-Installation vergeben — es wird nicht mitgeliefert oder im Projekt gespeichert.

Nach Eingabe des Befehls werden Sie zur Eingabe des Passworts aufgefordert

Hinweis:
Die Dump-Datei emission_data_dump.sql ist im Repository unter database/ enthalten.

Stellen Sie sicher, dass die Tabelle emission_data in der Datenbank existiert, bevor Sie den Dump importieren, oder importieren Sie die Datei, die auch das Schema enthält.