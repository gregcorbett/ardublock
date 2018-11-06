void D();
void G();
void dot();
void H();
void I();
void message();
void M();
void N();
void O();
void P();
void R();
void S();
void Y();
void dash();

void setup()
{
pinMode( 3, OUTPUT);
pinMode( 2 , INPUT);
pinMode( 9, OUTPUT);
pinMode( 8 , INPUT);
pinMode( 6 , INPUT);
}

void loop()
{
digitalWrite( 3 , digitalRead( 2) );
digitalWrite( 9 , digitalRead( 8) );
if (digitalRead( 6))
{
message();
}
}

void N()
{
dash();
dot();
delay( 100 );
}

void R()
{
dot();
dash();
dot();
delay( 100 );
}

void M()
{
dash();
dash();
delay( 100 );
}

void O()
{
dash();
dash();
dash();
delay( 100 );
}

void D()
{
dash();
dot();
dot();
delay( 100 );
}

void dot()
{
digitalWrite( 3 , HIGH );
delay( 100 );
digitalWrite( 3 , LOW );
delay( 100 );
}

void dash()
{
digitalWrite( 9 , HIGH );
delay( 300 );
digitalWrite( 9 , LOW );
delay( 100 );
}

void I()
{
dot();
dot();
delay( 100 );
}

void G()
{
dash();
dash();
dot();
delay( 100 );
}

void P()
{
dot();
dash();
dash();
dot();
delay( 100 );
}

void S()
{
dot();
dot();
dot();
delay( 100 );
}

void Y()
{
dash();
dot();
dash();
dash();
delay( 100 );
}

void H()
{
dot();
dot();
dot();
dot();
delay( 100 );
}

void message()
{
G();
O();
O();
D();
M();
O();
R();
N();
I();
N();
G();
S();
O();
P();
H();
Y();
}


