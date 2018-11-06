double tempIn = 0.0 ;
double tempC = 0.0 ;

void setup()
{
Serial.begin(9600);
pinMode( 2, OUTPUT);
}

void loop()
{
tempIn = analogRead(1) ;
tempC = ( tempIn / 2 ) ;
Serial.print(tempC);
Serial.print(" ");
Serial.println();
if (( ( tempC ) > ( 25 ) ))
{
digitalWrite( 2 , HIGH );
delay( 1000 );
digitalWrite( 2 , LOW );
delay( 1000 );
}
else
{
digitalWrite( 2 , HIGH );
}
}


