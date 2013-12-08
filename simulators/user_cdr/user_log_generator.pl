use feature ':5.10';

################## data seperating variables############
my $column_seperator = "|";
my $row_breaker = "\n";
########################################################

my $id = 1;

print "Please enter the file path of the csv with file name\n";
my $file_path = <>;

substr($file_path, -1, 1) = '';
unless(substr($file_path, -4, 4) eq ".csv"){
    if(substr($file_path, -1, 1) eq '/'){
	$file_path = $file_path."user_id";
    }
    my @file_path_parts = ($file_path, 'csv');
    $file_path = join('.', @file_path_parts);
}

open (FH, ">".$file_path) or die "Can't write to ".$file_path."$!";

print FH "1".$column_seperator;
print FH "{\"id\":\"880310186V\",\"msisdn\":\"0779545015\",\"name\":\"rajith delantha\",\"city\":\"kadawatha\"}".$row_breaker;
print FH "2".$column_seperator;
print FH "{\"id\":\"890894259V\",\"msisdn\":\"0775568798\",\"name\":\"abc\",\"city\":\"Colombo\"}".$row_breaker;
print FH "3".$column_seperator;
print FH "{\"id\":\"881361418V\",\"msisdn\":\"0778391747\",\"name\":\"abc\",\"city\":\"Colombo\"}".$row_breaker;
print FH "4".$column_seperator;
print FH "{\"id\":\"878253000V\",\"msisdn\":\"0778123567\",\"name\":\"abc \",\"city\":\"ccc\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;
print FH "5".$column_seperator;
print FH "{\"id\":\"880310789V\",\"msisdn\":\"0779545014\",\"name\":\"abc\",\"city\":\"hhh\"}".$row_breaker;




close(FH);

say "file added successfully here ".$file_path;