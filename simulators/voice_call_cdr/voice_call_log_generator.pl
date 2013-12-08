#!/usr/bin/perl

use feature "switch";

our @possibleValues=(["0779545015","0775568798","0778391747","0778391722","0778391723","0778391724","0778391726","0778391729"], #number making the call
["0112729729","94779000011"],  #number receiving the call
["0779545015","0775568798","0778391747"],  #number charged for the call
["answer","busy","divert","waiting"], #result of the call
["voice"]);   #call type

sub datetime{
	######################
	my $yearRange = 1; #one year
	my $startingYear = 2011; # starting from 2011

	my $monthRange = 12;   # all the 12 months
	my $startingMonth = 1; # string from January

	my $dayRange = 31; # 31 days
	my $startingDay=1; # starting from 1st
	######################
	my $yyyy = int(rand($yearRange))+$startingYear;
	my $mm	= int(rand($monthRange))+$startingMonth;
	my $dd = int(rand($dayRange))+$startingDay;
	my $HH = int(rand(24));
	my $min = int(rand(60));
	my $ss = int(rand(60));
#print "$yyyy-$mm-$dd $HH:$min:$ss";
push(@datarow,"$yyyy-$mm-$dd $HH:$min:$ss" )#"$yyyy$mm$dd$HH$min$ss"
}

sub duration_time {
    my $HH = int(rand(0));
    my $min = int(rand(10));
    my $ss = int(rand(60));
    push(@datarow,"$HH:$min:$ss" )

}

sub selectfield{
	my $val = $_[0];

	given ($val){
		when(1)     { push(@datarow,$possibleValues[0][int(rand(8))])}  #Number making the call
		when(2)     { push(@datarow,$possibleValues[1][int(rand(2))])}  #Number receiving the call
		when(3)		{ &datetime() }  #when the call start
		when(4)		{ &duration_time() }  #duration
	   	when(5) 	{ push(@datarow,$possibleValues[0][int(rand(3))]) } #Number charged call
		when(6) 	{ push(@datarow,$possibleValues[3][int(rand(4))]) } #result of the call
		when(7) 	{ push(@datarow,$possibleValues[4][int(rand(1))]) } #call type
	}
}


print "The number of records have to be generate: ";
our $numberofdata=<>;
print "Enter the path for the file: ";
our $fullname =<>;
print "Enter the starting sequence number: ";
our $startseq=<>;

$separator = "|"; # value separator

$surrounder="";

open FILE, ">$fullname" or die $!;

for ($j=0;$j<$numberofdata;$j++){
	our @datarow=();
	push(@datarow,$j+$startseq);
		for($i=1;$i<40;$i++){
			&selectfield($i);
		}
    $"=$surrounder.$separator.$surrounder;
	print FILE "$surrounder@datarow$surrounder\n";
}

close FILE;