package com.example.labdota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labdota.ui.theme.LabdotaTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.material3.ButtonDefaults


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
            }
        }
    }

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(R.color.bg_color))
    {

    LazyColumn {
        item { Header() }
        item { Box(Modifier.padding(20.dp, 20.dp)) { Tags() } }
        item { Box(Modifier.padding(20.dp, 20.dp)) { Description() } }
        item { Box(Modifier.padding(20.dp, 20.dp)) { Screenshots() } }
        item { Box(Modifier.padding(20.dp, 20.dp)) { RatingAndReviews() } }
        item { Box(Modifier.padding(20.dp, 20.dp)) { Comments() } }
        item { Box(Modifier.padding(20.dp, 0.dp)) { Button() } }
        }
    }
}

@Preview
@Composable
fun Header() {
    val overlayOffset = 100f

    ConstraintLayout {
        val (headerImg, headerLogo, title) = createRefs()
        Image(
            painter = painterResource(R.drawable.header_image),
            contentDescription = "header image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(headerImg) {}
        )

        Surface(
            modifier = Modifier
                .size(120.dp, 120.dp - 40.dp)
                .padding(20.dp, 0.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(
                    2.dp,
                    color = colorResource(R.color.grey),
                    RoundedCornerShape(15.dp)
                )
                .constrainAs(headerLogo) { top.linkTo(headerImg.bottom, margin = (-20).dp) },
            color = colorResource(R.color.black),
        ) {
            Image(
                painter = painterResource(R.drawable.dota2logo),
                contentDescription = "logo image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(15.dp, 15.dp)
            )
        }
        Column (
            Modifier
                .constrainAs(title) {
                    bottom.linkTo(headerLogo.bottom, margin = (10).dp)
                    start.linkTo(headerLogo.end)
                }
        ) {
            Text(
                fontSize = 20.sp,
                letterSpacing = 0.5.sp,
                text = "DoTA 2",
                color = colorResource(R.color.white),
                fontWeight = FontWeight(700)
            )

            Row {
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(12.dp)
                )
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(12.dp)
                        .offset(2.dp)
                )
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(12.dp)
                        .offset(4.dp)
                )
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(12.dp)
                        .offset(6.dp)
                )
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(12.dp)
                        .offset(8.dp)

                )
                Text(
                    fontSize = 10.sp,
                    letterSpacing = 0.5.sp,
                    text = "70M",
                    color = colorResource(R.color.grey_1),
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .offset(12.dp)
                )


            }

        }

    }
}
@Preview
@Composable
fun Tags(
    tags : List<String> = listOf(
        "MMO",
        "STRATEGY",
        "MULTIPLAYER",
    )
) {

    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(tags) {tag ->
            Surface(
                color = colorResource(R.color.blue_1).copy(alpha = 0.24f),
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
            ){
                Text(
                    modifier = Modifier.padding(15.dp, 6.dp),
                    text = tag,
                    color = colorResource(R.color.blue_2)
                )
            }
        }
    }
}
@Preview
@Composable
fun Description() {
    Text(
        text = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
        color = colorResource(R.color.white).copy(alpha = 0.6f),
        fontSize = 12.sp,
        lineHeight = 19.sp,
        fontWeight = FontWeight(400),
        modifier = Modifier
            .width(327.dp)
            .height(76.dp)
    )
}

@Preview
@Composable
fun Screenshots(
    screenshots : List<Int> = listOf(
        R.drawable.vid_prew,
        R.drawable.vid_prew,
    )
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        items(screenshots) {screenshot ->
            Image(
                painter = painterResource(id = screenshot),
                contentDescription = "preview $screenshot",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(220.dp, 120.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
        }
    }
}
@Preview
@Composable
fun RatingAndReviews() {

    ConstraintLayout {
        val (star1,star2,star3,star4,star5, amount,points,title) = createRefs()


        Text(
            text = "Rating And Reviews",
            letterSpacing = 0.6.sp,
            fontSize = 16.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .width(160.dp)
                .height(23.dp)
                .constrainAs(title) {}
        )

        Text(
            text = "4.9",
            letterSpacing = 0.6.sp,
            fontSize = 48.sp,
            fontWeight = FontWeight(700),
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(0.dp, 12.dp)
                .width(80.dp)
                .height(58.dp)
                .constrainAs(points) {}
        )
        Image(
            imageVector = Icons.Filled.Star,
            contentDescription = "star",
            colorFilter = ColorFilter.tint(Color.Yellow),
            modifier = Modifier
                .height(13.dp)
                .width(12.dp)
                .constrainAs(star1) {
                    bottom.linkTo(title.bottom, margin = (-20).dp)
                    start.linkTo(points.end)
                }
        )
        Image(
            imageVector = Icons.Filled.Star,
            contentDescription = "star2",
            colorFilter = ColorFilter.tint(Color.Yellow),
            modifier = Modifier
                .height(13.dp)
                .width(12.dp)
                .offset(2.dp)
                .constrainAs(star2) {
                    bottom.linkTo(title.bottom, margin = (-20).dp)
                    start.linkTo(star1.end)
                }
        )
        Image(
            imageVector = Icons.Filled.Star,
            contentDescription = "star3",
            colorFilter = ColorFilter.tint(Color.Yellow),
            modifier = Modifier
                .height(13.dp)
                .width(12.dp)
                .offset(4.dp)
                .constrainAs(star3) {
                    bottom.linkTo(title.bottom, margin = (-20).dp)
                    start.linkTo(star2.end)
                }

        )
        Image(
            imageVector = Icons.Filled.Star,
            contentDescription = "star4",
            colorFilter = ColorFilter.tint(Color.Yellow),
            modifier = Modifier
                .height(13.dp)
                .width(12.dp)
                .offset(6.dp)
                .constrainAs(star4) {
                    bottom.linkTo(title.bottom, margin = (-20).dp)
                    start.linkTo(star3.end)
                }
        )
        Image(
            imageVector = Icons.Filled.Star,
            contentDescription = "star5",
            colorFilter = ColorFilter.tint(Color.Yellow),
            modifier = Modifier
                .height(13.dp)
                .width(12.dp)
                .offset(8.dp)
                .constrainAs(star5) {
                    bottom.linkTo(title.bottom, margin = (-20).dp)
                    start.linkTo(star4.end)
                }

        )
        Text(
            text = "70M Reviews",
            letterSpacing = 0.5.sp,
            fontSize = 12.sp,
            color = colorResource(R.color.reviews_text_color),
            modifier = Modifier
                .width(90.dp)
                .height(23.dp)
                .constrainAs(amount) {
                    bottom.linkTo(title.bottom, margin = (-45).dp)
                    start.linkTo(points.end)
                }
        )

    }
}

@Preview
@Composable
fun Comments() {
    Column {

        Row {
            Image(
                painter = painterResource(R.drawable.dota2logo),
                contentDescription = "header image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)

            )
            Column {
                Text(
                    text = "Vladimir Mulin",
                    color = Color.White
                )
                Text(
                    text = "09.11.2023",
                    color = Color.Gray.copy(alpha = 0.8f)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(5.dp)
        )
        Text(
            text = "На ивокере пятёрке не играл – жизни не видел.",
            color = Color.White.copy(alpha = 0.6f),
            fontSize = 12.sp,
            letterSpacing = 0.5.sp,
            modifier = Modifier
                .padding(0.dp)


        )
        Spacer(
                modifier = Modifier
                    .height(5.dp)
        )

    }


        Divider(

            thickness = 1.dp,
            color = colorResource(R.color.grey_1),
            modifier = Modifier

                .padding(15.dp,80.dp,15.dp,0.dp)

        )
    Column(
        modifier = Modifier
            .padding(0.dp,100.dp,0.dp,0.dp)
    ) {

        Row {
            Image(
                painter = painterResource(R.drawable.dota2logo),
                contentDescription = "header image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)

            )
            Column {
                Text(
                    text = "Nikita Konyakov",
                    color = Color.White
                )
                Text(
                    text = "10.11.2023",
                    color = Color.Gray.copy(alpha = 0.8f)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(5.dp)
        )
        Text(
            text = "Я не успел сделать лабу...",
            color = Color.White.copy(alpha = 0.6f),
            fontSize = 12.sp,
            letterSpacing = 0.5.sp,
            modifier = Modifier
                .padding(0.dp)


        )
        Spacer(
            modifier = Modifier
                .height(5.dp)
        )

    }

}
@Preview
@Composable
fun Button() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button))
    ) {
        Text(
            text = "Install",
            fontSize = 20.sp,
            color = Color.Black,
            letterSpacing = 0.6.sp
        )
    }
}