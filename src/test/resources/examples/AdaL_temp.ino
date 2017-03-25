int sensorVal = 0 ;
int tempVal = 0 ;

void lights();

void setup()
{
pinMode( 8 , OUTPUT);
pinMode( 7 , OUTPUT);
pinMode( 6 , OUTPUT);
pinMode( 5 , OUTPUT);
pinMode( 4 , OUTPUT);
}

void loop()
{
sensorVal = analogRead(0) ;
tempVal = ( sensorVal / 2 ) ;
lights();
}

void lights()
{
if (( ( tempVal ) > ( 24 ) ))
{
digitalWrite( 8 , HIGH );
}
else
{
if (( ( tempVal ) > ( 21 ) ))
{
digitalWrite( 7 , HIGH );
}
else
{
if (( ( tempVal ) > ( 18 ) ))
{
digitalWrite( 6 , HIGH );
}
else
{
if (( ( tempVal ) > ( 16 ) ))
{
digitalWrite( 5 , HIGH );
}
else
{
digitalWrite( 4 , HIGH );
}
}
}
}
delay( 1 );
digitalWrite( 8 , LOW );
digitalWrite( 7 , LOW );
digitalWrite( 6 , LOW );
digitalWrite( 5 , LOW );
digitalWrite( 4 , LOW );
}


