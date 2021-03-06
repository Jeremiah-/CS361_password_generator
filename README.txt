UTEID: kdh2289; jhm2464;
FIRSTNAME: Kaelin; Jeremiah;
LASTNAME: Hooper; Martinez;
CSACCOUNT: kaelin; jeremiah;
EMAIL: kaelin@cs.utexas.edu; Jeremiah.H.Martinez@utexas.edu;

[Program 5]
[Description]
This program creates random passwords based on the frequency of how a letter follows another in a word, from a given file (Example: “True”, “r” follows “T”).
To run it use 'java Passwords reference-Filename N k', where reference-filename is the file you want to base the letter frequencies from, N the number of passwords to produce, and k the length of the passwords.
There is only one file that does everything, Passwords.java, in the main method, with helper methods that do non-essential things. The main function is creating the passwords, which is done by taking the sum of the number of times the current letter has appeared behind each letter of the alphabet inside the file and creating a random number that falls between 0 and the sum. Each letter will have varying ranges and the next letter in the password is determined by where the random number falls.
Everything prints to the terminal but the table is very large so make sure to enlarge the terminal to max capacity.

[Finish]
We finished all requrirements.

[Source of Reference File]
The file is located in the file directory, /usr/share/dict/words.pre-dictionaries-common
There are 99171 lines but each line is a word. Almost all of the words are english.
The size of the file is 938.8 kB

 
[Test Cases]
[Input of test 1]
java Passwords words.pre-dictionaries-common 15 15

[Output of test 1]

            A     B     C     D     E     F     G     H     I     J     K     L     M     N     O     P     Q     R     S     T     U     V     W     X     Y     Z     
A:         63  2180  3524  2360   235   580  1883   309  2078    71   798  5750  2455  8538    74  1996    78  7397  3398  9184  1251   995   594   198   910   360

B:       2277   551    36    49  2314    14     6    28  1691    61     4  2370    46    40  1863    10     0  1504   344    93  1355    22    20     0   163     0

C:       4448     6   524    17  2855     6    11  3903  2177     0  2242  1310    16    16  5370     6    56  1872    97  2056  1479     2     0     0   318    17

D:       1468   148    88   567  5483    78   406   115  4198    84    13   685   161   194  1539    63     6   999   301    54   853   123   177     0   213    19

E:       3782   670  2740  1780  2042  1013  1007   325   851    93   193  4272  2241  8102   607  1485   240 12502  7216  3271   428  1082   659  1187   528   146

F:       1007    19     5     5  1250   902    10    13  1916     3     4  1094     8    17  1296     4     0   888    25   365   981     0     1     0    89     0

G:       1750    36     4    25  2630    28   667  1057  1565     6    12  1028   144   524  1006    25     1  1711   126    75   978     0    50     0   186    13

H:       3158   109    30    41  4202    63    10    35  2835    10    14   234   227   192  2964    29     5   607    60   622   874     4   131     0   436     3

I:       2826   952  4202  1811  4285  1159  1945    50    18    48   293  3558  2032 16623  5252  1169   155  1895  6282  4906   306  1734    36   143    18  1513

J:        522     0     0     0   346     2     0     0   155     0     2     0     0     0   428     0     0     2     3     0   465     0     0     0     0     0

K:        508    85    14    30  2067    48    13   146  1418    10    43   366    66   291   213    47     0   131   208    38   131     0    79     0   116     0

L:       5062   201   228   660  6653   215   181    62  6916     8   247  4029   286   177  3535   225     9    64   305   805  1501   258    55     0   591    13

M:       4394  1104   121    12  3878    65     3    22  3361     0     1    92   909   173  2397  1858     7    41   154    11   953    11    19     0   150     0

N:       3268   206  3081  3594  5983   652  2934   230  3787   120   725   252   158  1147  1976   155   123   180  2157  5369   719   394   124    26   224    95

O:        950   894  1612  1253   402   484  1409   183   875    45   518  3251  2553  8358  2195  1726    59  5992  2009  2065  3597  1157  1438   233   317   144

P:       2679    51    30    27  3727    28    14  1343  2116     7    26  1708    52    42  2447  1185     0  2844   405   721  1001     1    30     0   128     2

Q:          8     1     0     0     0     0     0     0     8     0     0     0     0     0     2     0     0     0     0     0  1490     0     0     0     0     0

R:       7274   661  1056  1279  9215   293   765   233  7212    49   560   700  1211  1050  5240   549    46  1438  1271  2237  1681   415   185    10   765    28

S:       2104   158  2129    84  4228   130    70  2945  3761    17   553  1092   934   670  1801  1918   253    72  3356  7239  1865    29   503     0   407     7

T:       4332   157   601    31  8548   167    57  2817 10581    10    15   920   223   218  3509    81     0  3819   349  1805  1779    12   294     0   901   136

U:       1052   878  1084   819   940   341   706    30  1055    35   112  2327  1539  3651   211   899     8  3191  2772  2056    16    85    14    60    37   116

V:       1247     0     2     3  3439     0     1     3  1828     0     0    16     0     2   604     1     0    17    14     2   102    21     0     0    27     0

W:       1615    82    13    94  1230    32    17   491  1174     0    41   173    35   296   891    40     0   278   125    37    21     0    10     0    29     6

X:        126     3   158     0   269     6     3    63   337     0     0     8     3     3    77   310     2     0     3   269    67     1     9     2    38     2

Y:        424   129   261   135   456    47    85    52   374     7    16   279   318   282   241   348     2   217   359   146    82     9   102    19     5    26

Z:        468     7     2     1   958     0     1    30   544     0     4    92    12    12   183    12     3     6     5     9    41     9    10     0    27   222
Passwords are:
 ffissstherbestia
 tinacasonulefrea
 tctiogatizexenlp
 qurboyazampuphne
 mutroorscollasha
 wptogominnringig
 viseecltwormanec
 bitantecoutrilin
 binkncisonegenco
 tisutoosprllexis
 cemamoallereanon
 nerieliolencovar
 nembiclthendexan
 shtabeaymbleainf
 wardiguninslleli

[Input of test 2]
java Passwords words.pre-dictionaries-common 15 10

[Output of test 2]

            A     B     C     D     E     F     G     H     I     J     K     L     M     N     O     P     Q     R     S     T     U     V     W     X     Y     Z     
A:         63  2180  3524  2360   235   580  1883   309  2078    71   798  5750  2455  8538    74  1996    78  7397  3398  9184  1251   995   594   198   910   360

B:       2277   551    36    49  2314    14     6    28  1691    61     4  2370    46    40  1863    10     0  1504   344    93  1355    22    20     0   163     0

C:       4448     6   524    17  2855     6    11  3903  2177     0  2242  1310    16    16  5370     6    56  1872    97  2056  1479     2     0     0   318    17

D:       1468   148    88   567  5483    78   406   115  4198    84    13   685   161   194  1539    63     6   999   301    54   853   123   177     0   213    19

E:       3782   670  2740  1780  2042  1013  1007   325   851    93   193  4272  2241  8102   607  1485   240 12502  7216  3271   428  1082   659  1187   528   146

F:       1007    19     5     5  1250   902    10    13  1916     3     4  1094     8    17  1296     4     0   888    25   365   981     0     1     0    89     0

G:       1750    36     4    25  2630    28   667  1057  1565     6    12  1028   144   524  1006    25     1  1711   126    75   978     0    50     0   186    13

H:       3158   109    30    41  4202    63    10    35  2835    10    14   234   227   192  2964    29     5   607    60   622   874     4   131     0   436     3

I:       2826   952  4202  1811  4285  1159  1945    50    18    48   293  3558  2032 16623  5252  1169   155  1895  6282  4906   306  1734    36   143    18  1513

J:        522     0     0     0   346     2     0     0   155     0     2     0     0     0   428     0     0     2     3     0   465     0     0     0     0     0

K:        508    85    14    30  2067    48    13   146  1418    10    43   366    66   291   213    47     0   131   208    38   131     0    79     0   116     0

L:       5062   201   228   660  6653   215   181    62  6916     8   247  4029   286   177  3535   225     9    64   305   805  1501   258    55     0   591    13

M:       4394  1104   121    12  3878    65     3    22  3361     0     1    92   909   173  2397  1858     7    41   154    11   953    11    19     0   150     0

N:       3268   206  3081  3594  5983   652  2934   230  3787   120   725   252   158  1147  1976   155   123   180  2157  5369   719   394   124    26   224    95

O:        950   894  1612  1253   402   484  1409   183   875    45   518  3251  2553  8358  2195  1726    59  5992  2009  2065  3597  1157  1438   233   317   144

P:       2679    51    30    27  3727    28    14  1343  2116     7    26  1708    52    42  2447  1185     0  2844   405   721  1001     1    30     0   128     2

Q:          8     1     0     0     0     0     0     0     8     0     0     0     0     0     2     0     0     0     0     0  1490     0     0     0     0     0

R:       7274   661  1056  1279  9215   293   765   233  7212    49   560   700  1211  1050  5240   549    46  1438  1271  2237  1681   415   185    10   765    28

S:       2104   158  2129    84  4228   130    70  2945  3761    17   553  1092   934   670  1801  1918   253    72  3356  7239  1865    29   503     0   407     7

T:       4332   157   601    31  8548   167    57  2817 10581    10    15   920   223   218  3509    81     0  3819   349  1805  1779    12   294     0   901   136

U:       1052   878  1084   819   940   341   706    30  1055    35   112  2327  1539  3651   211   899     8  3191  2772  2056    16    85    14    60    37   116

V:       1247     0     2     3  3439     0     1     3  1828     0     0    16     0     2   604     1     0    17    14     2   102    21     0     0    27     0

W:       1615    82    13    94  1230    32    17   491  1174     0    41   173    35   296   891    40     0   278   125    37    21     0    10     0    29     6

X:        126     3   158     0   269     6     3    63   337     0     0     8     3     3    77   310     2     0     3   269    67     1     9     2    38     2

Y:        424   129   261   135   456    47    85    52   374     7    16   279   318   282   241   348     2   217   359   146    82     9   102    19     5    26

Z:        468     7     2     1   958     0     1    30   544     0     4    92    12    12   183    12     3     6     5     9    41     9    10     0    27   222
Passwords are:
 qurineditel
 ginteunerva
 esuentifopp
 ghituasabul
 queronkleee
 blivisetifr
 heradicassi
 qubudytispe
 dlonnderant
 nestelovees
 bidunkenson
 sinitesqust
 ueneankines
 mateocorzor
 coosintivee


[Input of test 3]
java Passwords words.pre-dictionaries-common 15 5

[Output of test 3]

            A     B     C     D     E     F     G     H     I     J     K     L     M     N     O     P     Q     R     S     T     U     V     W     X     Y     Z     
A:         63  2180  3524  2360   235   580  1883   309  2078    71   798  5750  2455  8538    74  1996    78  7397  3398  9184  1251   995   594   198   910   360

B:       2277   551    36    49  2314    14     6    28  1691    61     4  2370    46    40  1863    10     0  1504   344    93  1355    22    20     0   163     0

C:       4448     6   524    17  2855     6    11  3903  2177     0  2242  1310    16    16  5370     6    56  1872    97  2056  1479     2     0     0   318    17

D:       1468   148    88   567  5483    78   406   115  4198    84    13   685   161   194  1539    63     6   999   301    54   853   123   177     0   213    19

E:       3782   670  2740  1780  2042  1013  1007   325   851    93   193  4272  2241  8102   607  1485   240 12502  7216  3271   428  1082   659  1187   528   146

F:       1007    19     5     5  1250   902    10    13  1916     3     4  1094     8    17  1296     4     0   888    25   365   981     0     1     0    89     0

G:       1750    36     4    25  2630    28   667  1057  1565     6    12  1028   144   524  1006    25     1  1711   126    75   978     0    50     0   186    13

H:       3158   109    30    41  4202    63    10    35  2835    10    14   234   227   192  2964    29     5   607    60   622   874     4   131     0   436     3

I:       2826   952  4202  1811  4285  1159  1945    50    18    48   293  3558  2032 16623  5252  1169   155  1895  6282  4906   306  1734    36   143    18  1513

J:        522     0     0     0   346     2     0     0   155     0     2     0     0     0   428     0     0     2     3     0   465     0     0     0     0     0

K:        508    85    14    30  2067    48    13   146  1418    10    43   366    66   291   213    47     0   131   208    38   131     0    79     0   116     0

L:       5062   201   228   660  6653   215   181    62  6916     8   247  4029   286   177  3535   225     9    64   305   805  1501   258    55     0   591    13

M:       4394  1104   121    12  3878    65     3    22  3361     0     1    92   909   173  2397  1858     7    41   154    11   953    11    19     0   150     0

N:       3268   206  3081  3594  5983   652  2934   230  3787   120   725   252   158  1147  1976   155   123   180  2157  5369   719   394   124    26   224    95

O:        950   894  1612  1253   402   484  1409   183   875    45   518  3251  2553  8358  2195  1726    59  5992  2009  2065  3597  1157  1438   233   317   144

P:       2679    51    30    27  3727    28    14  1343  2116     7    26  1708    52    42  2447  1185     0  2844   405   721  1001     1    30     0   128     2

Q:          8     1     0     0     0     0     0     0     8     0     0     0     0     0     2     0     0     0     0     0  1490     0     0     0     0     0

R:       7274   661  1056  1279  9215   293   765   233  7212    49   560   700  1211  1050  5240   549    46  1438  1271  2237  1681   415   185    10   765    28

S:       2104   158  2129    84  4228   130    70  2945  3761    17   553  1092   934   670  1801  1918   253    72  3356  7239  1865    29   503     0   407     7

T:       4332   157   601    31  8548   167    57  2817 10581    10    15   920   223   218  3509    81     0  3819   349  1805  1779    12   294     0   901   136

U:       1052   878  1084   819   940   341   706    30  1055    35   112  2327  1539  3651   211   899     8  3191  2772  2056    16    85    14    60    37   116

V:       1247     0     2     3  3439     0     1     3  1828     0     0    16     0     2   604     1     0    17    14     2   102    21     0     0    27     0

W:       1615    82    13    94  1230    32    17   491  1174     0    41   173    35   296   891    40     0   278   125    37    21     0    10     0    29     6

X:        126     3   158     0   269     6     3    63   337     0     0     8     3     3    77   310     2     0     3   269    67     1     9     2    38     2

Y:        424   129   261   135   456    47    85    52   374     7    16   279   318   282   241   348     2   217   359   146    82     9   102    19     5    26

Z:        468     7     2     1   958     0     1    30   544     0     4    92    12    12   183    12     3     6     5     9    41     9    10     0    27   222
Passwords are:
 tugola
 givige
 gagera
 qublop
 tinfis
 sellti
 steses
 bacifi
 qumpul
 ckemef
 dexero
 dionca
 tianas
 hatelp
 jakich


[Input of test 4]
java Passwords words.pre-dictionaries-common 30 10

[Output of test 4]

            A     B     C     D     E     F     G     H     I     J     K     L     M     N     O     P     Q     R     S     T     U     V     W     X     Y     Z     
A:         63  2180  3524  2360   235   580  1883   309  2078    71   798  5750  2455  8538    74  1996    78  7397  3398  9184  1251   995   594   198   910   360

B:       2277   551    36    49  2314    14     6    28  1691    61     4  2370    46    40  1863    10     0  1504   344    93  1355    22    20     0   163     0

C:       4448     6   524    17  2855     6    11  3903  2177     0  2242  1310    16    16  5370     6    56  1872    97  2056  1479     2     0     0   318    17

D:       1468   148    88   567  5483    78   406   115  4198    84    13   685   161   194  1539    63     6   999   301    54   853   123   177     0   213    19

E:       3782   670  2740  1780  2042  1013  1007   325   851    93   193  4272  2241  8102   607  1485   240 12502  7216  3271   428  1082   659  1187   528   146

F:       1007    19     5     5  1250   902    10    13  1916     3     4  1094     8    17  1296     4     0   888    25   365   981     0     1     0    89     0

G:       1750    36     4    25  2630    28   667  1057  1565     6    12  1028   144   524  1006    25     1  1711   126    75   978     0    50     0   186    13

H:       3158   109    30    41  4202    63    10    35  2835    10    14   234   227   192  2964    29     5   607    60   622   874     4   131     0   436     3

I:       2826   952  4202  1811  4285  1159  1945    50    18    48   293  3558  2032 16623  5252  1169   155  1895  6282  4906   306  1734    36   143    18  1513

J:        522     0     0     0   346     2     0     0   155     0     2     0     0     0   428     0     0     2     3     0   465     0     0     0     0     0

K:        508    85    14    30  2067    48    13   146  1418    10    43   366    66   291   213    47     0   131   208    38   131     0    79     0   116     0

L:       5062   201   228   660  6653   215   181    62  6916     8   247  4029   286   177  3535   225     9    64   305   805  1501   258    55     0   591    13

M:       4394  1104   121    12  3878    65     3    22  3361     0     1    92   909   173  2397  1858     7    41   154    11   953    11    19     0   150     0

N:       3268   206  3081  3594  5983   652  2934   230  3787   120   725   252   158  1147  1976   155   123   180  2157  5369   719   394   124    26   224    95

O:        950   894  1612  1253   402   484  1409   183   875    45   518  3251  2553  8358  2195  1726    59  5992  2009  2065  3597  1157  1438   233   317   144

P:       2679    51    30    27  3727    28    14  1343  2116     7    26  1708    52    42  2447  1185     0  2844   405   721  1001     1    30     0   128     2

Q:          8     1     0     0     0     0     0     0     8     0     0     0     0     0     2     0     0     0     0     0  1490     0     0     0     0     0

R:       7274   661  1056  1279  9215   293   765   233  7212    49   560   700  1211  1050  5240   549    46  1438  1271  2237  1681   415   185    10   765    28

S:       2104   158  2129    84  4228   130    70  2945  3761    17   553  1092   934   670  1801  1918   253    72  3356  7239  1865    29   503     0   407     7

T:       4332   157   601    31  8548   167    57  2817 10581    10    15   920   223   218  3509    81     0  3819   349  1805  1779    12   294     0   901   136

U:       1052   878  1084   819   940   341   706    30  1055    35   112  2327  1539  3651   211   899     8  3191  2772  2056    16    85    14    60    37   116

V:       1247     0     2     3  3439     0     1     3  1828     0     0    16     0     2   604     1     0    17    14     2   102    21     0     0    27     0

W:       1615    82    13    94  1230    32    17   491  1174     0    41   173    35   296   891    40     0   278   125    37    21     0    10     0    29     6

X:        126     3   158     0   269     6     3    63   337     0     0     8     3     3    77   310     2     0     3   269    67     1     9     2    38     2

Y:        424   129   261   135   456    47    85    52   374     7    16   279   318   282   241   348     2   217   359   146    82     9   102    19     5    26

Z:        468     7     2     1   958     0     1    30   544     0     4    92    12    12   183    12     3     6     5     9    41     9    10     0    27   222
Passwords are:
 cpsaspentin
 cenatendioh
 cephitymepi
 sthriesoter
 urmpoygrvat
 nclluncouou
 belsshanntr
 quronalelow
 unebifuenct
 dindantitit
 dexelistonc
 fongmedrneo
 vedinedabon
 chighoxhind
 upogalornsu
 tinginerlel
 vexpracuden
 ccouencatio
 coldouramer
 deamivatela
 bparfudiler
 phetateroay
 ufictherurd
 ssuexunpolu
 dlettillemo
 thenateenig
 stellaneurs
 metideronis
 bogevebingo
 sounangrnet

