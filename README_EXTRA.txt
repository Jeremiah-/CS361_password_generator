UTEID: kdh2289; jhm2464;
FIRSTNAME: Kaelin; Jeremiah;
LASTNAME: Hooper; Martinez;
CSACCOUNT: kaelin; jeremiah;
EMAIL: kaelin@cs.utexas.edu; Jeremiah.H.Martinez@utexas.edu;

[Program 5]
[Description]

Extra credit description:
In order to run this program, enter "java Passwords reference-Filename N k rejectWordsFile"
The only difference between this and the original is the rejectWordsFile. This file contains
all the words (4 letters or more) that if are a substring of a generated password, will make the 
password void. Rejected passwords will be shown on the terminal along with the substring that
made them rejects.

This program creates random passwords based on the frequency of how a letter follows another in a word, from a given file (Example: “True”,"u" follows “r” 
and that follows “T”). To run it use 'java Passwords reference-Filename N k rejectWordsFile', where reference-filename is the file you want to base the letter frequencies from, N the number of passwords to produce, and k the length of the passwords.
There is only one file, Passwords.java, that does everything in the main method, with helper methods that do non-essential things. The main function is creating the passwords, which is done by taking the sum of the number of times the current letter has appeared behind each letter of the alphabet inside the file and creating a random number that falls between 0 and the sum. Each letter will have varying ranges and the next letter in the password is determined by where the random number falls.
Only rejected passwords and successful passwords are printed to the terminal.

[Finish]
We finished all requrirements. We implemented the password rejection and 3rd order entropy.

[Source of Reference File]
The file is located in the file directory, /usr/share/dict/words.pre-dictionaries-common
There are 99171 lines but each line is a word. Almost all of the words are english.
The size of the file is 938.8 kB

 
[Test Cases]
[Input of test 1]
java Passwords_3 words.pre-dictionaries-common 20 10 words.pre-dictionaries-common

[Output of test 1]

Rejected password "kantaisabl" because of substring "kant"
Rejected password "brobillwor" because of substring "bill"
Rejected password "orgabshoba" because of substring "gabs"
Rejected password "flibolliph" because of substring "boll"
Rejected password "vaniusline" because of substring "line"
Rejected password "virchantur" because of substring "chan"
Rejected password "lleedishes" because of substring "dish"
Rejected password "utnesemist" because of substring "mist"
Rejected password "roatatentr" because of substring "tate"
Rejected password "claterrimp" because of substring "late"
Rejected password "lewearsano" because of substring "ears"
Rejected password "llinallial" because of substring "lina"
Rejected password "rusthrunke" because of substring "rust"
Rejected password "wayinabill" because of substring "bill"
Rejected password "abiroffiro" because of substring "biro"
Rejected password "hanatercel" because of substring "nate"
Rejected password "caterectit" because of substring "cater"
Passwords are:
 reseniumas
 witedisres
 undifigack

[Input of test 2]
java Passwords_3 words.pre-dictionaries-common 20 15 words.pre-dictionaries-common

[Output of test 2]

Rejected password "riaticsicefulif" because of substring "tics"
Rejected password "crodgenessairev" because of substring "gene"
Rejected password "iondylamothlogg" because of substring "moth"
Rejected password "knessetchiessie" because of substring "essie"
Rejected password "sadrationnegabs" because of substring "gabs"
Rejected password "extrageotinnies" because of substring "extra"
Rejected password "hatarzkossivall" because of substring "siva"
Rejected password "moruckindethent" because of substring "kind"
Rejected password "fustlowinessawa" because of substring "ines"
Rejected password "watchothwadicki" because of substring "dick"
Rejected password "koerchisternati" because of substring "erna"
Passwords are:
 catalismaciatan
 ficatificencych
 ricinsublulplam
 equistomorceati
 atergerathossle
 nompotradinnuen
 citacefentionio
 sticemizeramege
 ghhaperyokaziev


[Input of test 3]
java Passwords_3 words.pre-dictionaries-common 20 20 words.pre-dictionaries-common

[Output of test 3]

Rejected password "astingrastrawlespanc" because of substring "span"
Rejected password "pplenterebillepicatt" because of substring "bill"
Rejected password "ecturepicateriaracce" because of substring "cater"
Rejected password "itarderipanimpedelac" because of substring "impede"
Rejected password "precentoniallationeu" because of substring "cent"
Rejected password "turaftionsupteepubsi" because of substring "ions"
Rejected password "petammanniessaingeer" because of substring "amman"
Rejected password "crearraconitsubhuthl" because of substring "nits"
Rejected password "whelurberesherackine" because of substring "hera"
Rejected password "ckpostioninonesembut" because of substring "none"
Rejected password "pituritianterrativer" because of substring "ante"
Rejected password "gorapplerscariasharo" because of substring "apple"
Rejected password "sionnerectiontattect" because of substring "erect"
Rejected password "cionsompoloranukysie" because of substring "ions"
Rejected password "arizerieverborkitipr" because of substring "ariz"
Rejected password "stankeulanderangendl" because of substring "derange"
Rejected password "torcillitietuantiven" because of substring "anti"
Rejected password "lacitypermartonatiba" because of substring "city"
Rejected password "aticketolutenimporal" because of substring "lute"
Passwords are:
 experachnessreptiplo


[Input of test 4]
java Passwords_3 words.pre-dictionaries-common 20 8 words.pre-dictionaries-common

[Output of test 4]

Rejected password "pregaria" because of substring "aria"
Rejected password "mushectu" because of substring "mush"
Rejected password "faricent" because of substring "cent"
Rejected password "ranestap" because of substring "nest"
Rejected password "repoketr" because of substring "poke"
Rejected password "dicafrof" because of substring "afro"
Rejected password "lateefac" because of substring "late"
Rejected password "chirenta" because of substring "hire"
Rejected password "wdinglop" because of substring "ding"
Passwords are:
 orcausky
 encerple
 sneinver
 chretrun
 dromiges
 goiscisc
 phyphoge
 ercenfai
 pinanitt
 bdessuic
 ltarkwad

