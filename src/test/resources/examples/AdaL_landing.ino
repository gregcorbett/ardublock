int counter = 0 ;
int oldLight = 0 ;
int max = 0 ;
int min = 0 ;
int light = 0 ;
int range = 0 ;
int diff = 0 ;

void ldrSetup();
void distance();
void speed();

void setup()
{
pinMode( 8, OUTPUT);
pinMode( 9, OUTPUT);
pinMode( 13, OUTPUT);
pinMode( 12, OUTPUT);
pinMode( 11, OUTPUT);
pinMode( 10, OUTPUT);
}

void loop()
{
if (( ( counter ) == ( 0 ) ))
{
ldrSetup();
}
counter = ( counter + 1 ) ;
oldLight = light ;
distance();
speed();
}

void ldrSetup()
{
max = -1000 ;
min = 1000 ;
digitalWrite( 8 , HIGH );
for(int i=0; i < 5000; i++)
{
light = analogRead(A0) ;
if (( ( light ) > ( max ) ))
{
max = light ;
}
if (( ( light ) < ( min ) ))
{
min = light ;
}
delay( 1 );
}
range = ( max - min ) ;
digitalWrite( 8 , LOW );
digitalWrite( 9 , HIGH );
delay( 2000 );
digitalWrite( 9 , LOW );
}

void speed()
{
diff = ( oldLight - light ) ;
delay( 1 );
if (( ( diff ) > ( 50 ) ))
{
digitalWrite( 13 , HIGH );
}
else
{
if (( ( diff ) > ( 25 ) ))
{
digitalWrite( 12 , HIGH );
}
else
{
digitalWrite( 11 , HIGH );
}
}
}

void distance()
{
light = analogRead(A0) ;
if (( ( light ) > ( ( ( 0.8 * range ) + min ) ) ))
{
digitalWrite( 10 , HIGH );
}
else
{
if (( ( light ) > ( ( ( 0.5 * range ) + min ) ) ))
{
digitalWrite( 9 , HIGH );
}
else
{
if (( ( light ) > ( ( ( 0.25 * range ) + min ) ) ))
{
digitalWrite( 9 , HIGH );
digitalWrite( 8 , HIGH );
}
else
{
digitalWrite( 8 , HIGH );
}
}
}
delay( 1 );
digitalWrite( 8 , LOW );
digitalWrite( 9 , LOW );
digitalWrite( 10 , LOW );
}


