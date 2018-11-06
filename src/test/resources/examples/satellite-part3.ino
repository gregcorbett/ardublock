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
delay( 1000 );
digitalWrite( 2 , LOW );
delay( 1000 );
}
else
{
digitalWrite( 2 , HIGH );
}
}


