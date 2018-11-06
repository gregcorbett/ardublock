void setup()
{
pinMode( 4 , INPUT);
pinMode( 2, OUTPUT);
}

void loop()
{
if (digitalRead( 4))
{
digitalWrite( 2 , HIGH );
delay( 500 );
digitalWrite( 2 , LOW );
delay( 500 );
}
else
{
digitalWrite( 2 , LOW );
}
}


