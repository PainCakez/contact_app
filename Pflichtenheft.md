# Pflichtenheft

## Einsatz
* Zielgruppe
```
Felix
```
* Anwendungsbereiche
```
Smartphone
```
* Betribesbedienungen
```
IOS / Android
```
## Produktbersicht
* Akteure
```
Stackholder: Felix
Entwickler: PainCoding GmbH
```

## Funktionen
#### /F_Add_001/
```
Über einen Hinzufügen-Button im Kontakfenster, soll ein Kontakt zur Datenbank hinzugefügt werden.
```
#### /F_Add_002/
```
Über einen Hinzufügen-Button im Firmenfenster, soll eine Firma zur Datenbank hinzugefügt werden.
```
#### /F_Sort_001/
```
Man soll die Kontakte nach ihren Nachnamen sortieren können, die Firmen nach ihrem Anfangsbuchstabe, 
aufsteigend A-Z, absteigend Z-A
```
#### /F_Sort_003/
```
Man soll beim Auswählen einer Firma sich auch die jeweiligen Mitarbeiter anzeigen lassen können.
```
#### /F_Edit_001/
```
Die personenbezogenen Daten der Kontakte, sollen per Bearbeitungs-Button geändert werden können.
Foglich ändern sich somit die Daten in der Datenbank.
```
#### /F_Edit_002/
```
Die Informationen einer Firma, sollen per Bearbeitungs-Button geändert werden können.
Foglich ändern sich somit die Daten in der Datenbank.
```
#### /F_Delete_001/
```
Ein Kontakt kann über einen Lösch-Button gelöscht werden. Die Daten werden aus der Datenbank gelöscht.
```
#### /F_Delete_002/
```
Eine Firma kann über einen Lösch-Button aus der Datenbank entfernt werden. Wenn eine Firma gelöscht wird,
soll eine Meldung auftauchen die den Benutzer fragt, ob die Kontakte welche der Firma zugeteilt sind auch 
gelöscht werden sollen. Die Daten werden aus der Datenbank gelöscht.
```
#### /F_Delete_003/
```
Ein Mitarbeiter soll bei längerem Knopfdruck ausgewählt werden und es bietet sich anschließend die Option,
diesen aus der Firma zu entfernen. Folglich wird man gefragt ob der komplette Kontakt gelöscht werden soll.
Wenn der Benutzer "nein" wählt, dann wird der Mitarbeiter aus der Firma entfernt und der dazugehörige Kontakt
bleibt bestehen, verliert aber wiederrum seinen EIntrag in der "Firma"-Spalte der personenbezogenen Datenbank.
```

## Qualitätsanforderungen
* Richtlinien
```
Basierend auf den App-Store-Richtlininen und Design-Bedienungen des jeweiligen Betriebssystem:
Apple App-Store bzw. Google PlayStore
```

## Layout
* zwei Spalten an der Oberseite zum auswählen:
```
Kontakte
Firmen
```
* Einträge sollen unterteilt werden anhand:
```
Erster Buchstabe des Nachnamens, wenn nicht vorhanden, erster Buchstabe des Vornamens
Erster Buchstabe des Firmennamens
```
* Unter den obersten Spalten, zwei weitere Spalten mit der Beschriftung:
```
A-Z bzw. Z-A (/F_Sort_001/)
```
* Unten rechts befindet sich ein "+" Symbol. Bei Betätigung wird je nach ausgewählter obriger Spalte folgende
Funktion ausgeführt:
```
Kontakte: /F_Add_001/
Firmen: /F_Add_002/
```
* Beim auswählen einen Kontaktes/einer Firma, öffnet sich dieser/diese und die Daten werden angezeigt.

-> in folgendem Fenster werden oben rechts drei unternanderliegene Punkte angezeigt, wenn man auf diese klickt
   bieten sich einem folgende Optionen
```
Bearbeiten (Kontakt: /F_Edit_001/, Firma: /F_Edit_002/)
Löschen (Kontakt: /F_Delete_001/, Firma: /F_Delete_002/)
```
* Innerhalb des Fenster einer ausgewählten Firma, soll sich ein Mitarbeiter-Knopf befinden der folgende Funktion
ausführt:
```
/F_Sort_003/
```
  -> bei den angezeigten Mitarbeitern soll folgende Funktion angewendet werden können:
```
/F_Delete_003/
```


