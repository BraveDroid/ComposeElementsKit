package com.mobilez.elementskit.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobilez.compose.elementskit.R
import java.util.Locale

@Composable
fun ReadyForPickupCard(packageUIModel: ShipmentUIModel) {
    LazyColumn()
    {
        item {
            SectionDividerWithText("Gotowe do odbioru")
            CourierPackageCard()
            Spacer()
            ReceivedPackageCard("Gotowa do odbioru")
        }
        item {
            SectionDividerWithText("Pozostale")
            ReceivedPackageCard("Odebrana")
            Spacer()
        }
    }
}

@Preview
@Composable
fun TestCard() {
    val packageUIModel = ShipmentUIModel(
        number = "6567898654334567896543",
        status = "Widana do doreczenia",
        senderName = "",
        senderEmail = "",
        eventLog = listOf(
            EventLog(
                date = "pn.| 14.06.18| 11:3O",
                name = "Widana do doreczenia",
            ),
            EventLog(
                date = "pn.| 14.06.18| 11:3O",
                name = "Widana do doreczenia",
            ),
            EventLog(
                date = "pn.| 14.06.18| 11:3O",
                name = "Widana do doreczenia",
            ),
        ),
    )
    ReadyForPickupCard(packageUIModel)
}

@Composable
fun Spacer() {
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun SectionDividerWithText(text: String) {
    Box(modifier = Modifier.padding(vertical = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(Color.LightGray),
            )
            Text(
                text = text,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(Color.LightGray),
            )
        }
    }
}

@Preview
@Composable
fun PreviewTextDivider() {
    SectionDividerWithText("Gotowe do odbioru")
}

@Composable
fun CourierPackageCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(Modifier.padding(bottom = 8.dp)) {
                Text(
                    text = "NR PRZESYLKI".uppercase(Locale.ROOT),
                    color = Color.Gray,
                )
                Text(
                    text = "6567898654334567896543",
                    color = Color.DarkGray,
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.delivery_status_icon),
                contentDescription = "Truck Icon",
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "STATUS".uppercase(Locale.ROOT),
            color = Color.Gray,
        )
        Text(
            text = "Widana do doreczenia",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = "NADAWCA".uppercase(Locale.ROOT),
                    color = Color.Gray,
                )
                Text(
                    text = "addressmail@mail.pl",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "wiecej",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* Action ici */ },
                )
                Icon(Icons.Default.ArrowForward, contentDescription = "More Icon")
            }
        }
    }
}

@Preview
@Composable
fun PrevTrackingCard() {
    CourierPackageCard()
}

@Composable
fun ReceivedPackageCard(statusText: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            // .padding(bottom = 8.dp)
            .background(Color.White)
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(Modifier.padding(bottom = 8.dp)) {
                Text(
                    text = "NR PRZESYLKI".uppercase(Locale.ROOT),
                    color = Color.Gray,
                )
                Text(
                    text = "6567898654334567896543",
                    color = Color.DarkGray,
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.post),
                contentDescription = "Truck Icon",
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        )
        {
            Column() {
                Text(
                    text = "STATUS".uppercase(Locale.ROOT),
                    color = Color.Gray,
                )
                Text(
                    text = statusText,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
            }
            Column() {
                Text(
                    text = "CZEKA NA ODBIOR DO".uppercase(Locale.ROOT),
                    color = Color.Gray,
                )
                Text(
                    text = "pn.| 14.06.18| 11:3O",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.End),
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = "NADAWCA".uppercase(Locale.ROOT),
                    color = Color.Gray,
                )
                Text(
                    text = "addressmail@mail.pl",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "wiecej",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* Action ici */ },
                )
                Icon(Icons.Default.ArrowForward, contentDescription = "More Icon")
            }
        }
    }
}

@Preview
@Composable
fun PrevPostCard() {
    ReceivedPackageCard("Gotowa do odbioru")
}

data class ShipmentUIModel(
    val number: String,
    val status: String,
    val senderName: String,
    val senderEmail: String,
    val eventLog: List<EventLog>,
)

data class EventLog(
    val date: String,
    val name: String,
)

data class Operations(
    val collect: Boolean,
    val delete: Boolean,
    val endOfWeekCollection: Boolean,
    val expandAvizo: Boolean,
    val highlight: Boolean,
    val manualArchive: Boolean,
)

data class Receiver(
    val email: String,
    val name: String,
    val phoneNumber: String,
)

data class Sender(
    val email: String,
    val name: String,
    val phoneNumber: String,
)

data class Shipment(
    val eventLog: List<EventLog>,
    val expiryDate: String,
    val number: String,
    val openCode: String,
    val operations: Operations,
    val pickUpDate: String,
    val receiver: Receiver,
    val sender: Sender,
    val shipmentType: String,
    val status: String,
    val storedDate: String,
)

data class Shipments(
    val shipments: List<Shipment>,
)

