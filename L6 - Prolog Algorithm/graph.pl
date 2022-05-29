% Code adapted from cpp.edu

% --------------EDGES--------------
% Green Line - 9 edges
stations(al_mansoura,msheireb,3).
stations(msheireb,al_bidda,2).
stations(al_bidda,the_white_palace,3).
stations(the_white_palace,hamad_hospital,2).
stations(hamad_hospital,al_messila,3).
stations(al_messila,al_rayyan_al_qadeem,3).
stations(al_rayyan_al_qadeem,al_shaqab,2).
stations(al_shaqab,qatar_national_library,3).
stations(qatar_national_library,education_city,2).
stations(education_city,al_riffa,8).

% Red Line - 17 edges
stations(al_wakra,ras_bu_fontas,3).
stations(ras_bu_fontas,free_zone,3).
stations(free_zone,hamad_intl_airport,15).
stations(hamad_intl_airport,oqba_ibn_nafie,15).
stations(free_zone,oqba_ibn_nafie,3).
stations(oqba_ibn_nafie,al_matar_al_qadeem,3).
stations(al_matar_al_qadeem,umm_ghuwailina,2).
stations(umm_ghuwailina,al_doha_al_jadeeda,2).
stations(al_doha_al_jadeeda,msheireb,3).
stations(msheireb,al_bidda,2).
stations(al_bidda,corniche,3).
stations(corniche,west_bay,2).
stations(west_bay,decc,2).
stations(decc,al_qassar,4).
stations(al_qassar,katara,2).
stations(katara,legtaifiya,2).
stations(legtaifiya,qatar_university,4).
stations(qatar_university,lusail,4).

% Gold Line - 9 edges
stations(ras_bu_abboud,national_museum,3).
stations(national_museum,souq_waqif,2).
stations(souq_waqif,msheireb,2).
stations(msheireb,bin_mahmoud,2).
stations(bin_mahmoud,al_sadd,2).
stations(al_sadd,joaan,2).
stations(joaan,al_sudan,3).
stations(al_sudan,al_waab,3).
stations(al_waab,sport_city,3).
stations(sport_city,al_aziziyah,2).

% ------------ALGORITHM------------
% Edges work bi-directionally
connected(X,Y,L) :- stations(X,Y,L) ; stations(Y,X,L).

path(A,B,Path,Len) :-
        journey(A,B,[A],Q,Len), 
        reverse(Q,Path).

journey(A,B,P,[B|P],L) :- 
        connected(A,B,L).
journey(A,B,Visited,Path,L) :-
        connected(A,C,D),           
        C \== B,
        \+member(C,Visited),
        journey(C,B,[C|Visited],Path,L1),
        L is D+L1.  

quickest(A,B,Path,Length) :-
        setof([P,L],path(A,B,P,L),Set),
        Set = [_|_], % fails if empty
        minimal(Set,[Path,Length]).

minimal([F|R],M) :- min(R,F,M).

% Unifies and finds out the fastest route
min([],M,M).
min([[P,L]|R],[_,M],Min) :- L < M, !, min(R,[P,L],Min). 
min([_|R],M,Min) :- min(R,M,Min).
