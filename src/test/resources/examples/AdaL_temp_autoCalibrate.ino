int tempCalibrate = 0 ;
int normTemp = 0 ;
int tempIn = 0 ;
int tempC = 0 ;

void lights();

void setup()
{
pinMode( 8 , OUTPUT);
pinMode( 7 , OUTPUT);
pinMode( 6 , OUTPUT);
pinMode( 5 , OUTPUT);
pinMode( 4 , OUTPUT);
for(int led=0; led < 5; led++)
{
digitalWrite( ( led + 4 ) , HIGH );
delay( 150 );
digitalWrite( ( led + 4 ) , LOW );
tempCalibrate = ( tempCalibrate + analogRead(0) ) ;
}

normTemp = ( tempCalibrate / 10 ) ;

}

void loop()
{
tempIn = analogRead(0) ;
tempC = ( tempIn / 2 ) ;
lights();
}

void lights()
{
if (( ( tempC ) > ( ( normTemp + 4 ) ) ))
{
digitalWrite( 8 , HIGH );
}
else
{
if (( ( tempC ) > ( ( normTemp + 1 ) ) ))
{
digitalWrite( 7 , HIGH );
}
else
{
if (( ( tempC ) > ( ( normTemp - 1 ) ) ))
{
digitalWrite( 6 , HIGH );
}
else
{
if (( ( tempC ) > ( ( normTemp - 3 ) ) ))
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


