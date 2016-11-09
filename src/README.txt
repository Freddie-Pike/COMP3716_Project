-=README=-

-Tournament Format-

The TournamentFormat is one of the more complex ideas. The goal is to allow 
users the ability to choose a format for the tournament: Single/Double elimination
and Divisions. Users can choose the format any time after the tournament is created.
To allow for additional formats to be implemented, TournamentFormat is abstract. 
This will force new formats to extend TournamentFormat. The TournamentFormat handles
how teams get added to the CollectionType (see below).

One problem we had while designing the formats was that elimination formats used 
brackets, while division formats used a division. Brackets and divisions are similiar 
but different enough to be separate classes. To encourage flexibility and extensions, 
we created a CollectionType class. This class is also abstract so that new collections
will have to extend from it. Examples of collections would be Bracket and Division. 
CollectionType handles how teams within a collection (ex bracket) behave. 

The tester package contains three classes that highlight how the system works. The 
TournamentTester class sets up a Tournament and essentially acts as a master class: it
adds teams, sets a format, and simulates one round from a bracket. The SingleElimination
class is a sub-class of TournamentFormat. The constructor sets the CollectionType to
Bracket, and sortTeamsToCollection() method determines how the teams get matched with each
other. In this case, assume that teams are ranked in order, and we select the top team 
and match them with the middle ranking team. The next highest ranked team is matched
with the next middle ranked team and so on. Finally Bracket is a sub-class of CollectionType.
Bracket determines how Teams advance towards the next round. In this example though, we
simulate the winners and print them to the console.

The nature of how TournamentFormat and CollectionType allows people to extend and modify
tournaments to meet their needs. TournamentFormat describes how teams are sorted, while
CollectionType describes how teams advance through the tournament.