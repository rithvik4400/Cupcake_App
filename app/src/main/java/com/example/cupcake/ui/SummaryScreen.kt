package com.example.cupcake.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.components.FormattedPriceLabel
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val resources = LocalContext.current.resources

    val numberOfCupcakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )

    val newOrder = stringResource(R.string.new_cupcake_order)

    // ✅ Convert comma string → list
    val flavorList = orderUiState.flavor.split(",").map { it.trim() }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // 🔹 ORDER DETAILS
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.padding_small)
            )
        ) {

            // Quantity
            Text(stringResource(R.string.quantity).uppercase())
            Text(text = numberOfCupcakes, fontWeight = FontWeight.Bold)
            Divider(thickness = dimensionResource(R.dimen.thickness_divider))

            // ✅ MULTIPLE FLAVORS DISPLAY
            Text(stringResource(R.string.flavor).uppercase())

            flavorList.forEach { flavor ->
                Text(
                    text = "• $flavor",
                    fontWeight = FontWeight.Bold
                )
            }

            Divider(thickness = dimensionResource(R.dimen.thickness_divider))

            // Pickup Date
            Text(stringResource(R.string.pickup_date).uppercase())
            Text(text = orderUiState.date, fontWeight = FontWeight.Bold)

            Divider(thickness = dimensionResource(R.dimen.thickness_divider))

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

            // Price
            FormattedPriceLabel(
                subtotal = orderUiState.price,
                modifier = Modifier.align(Alignment.End)
            )
        }

        // 🔹 BUTTONS
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.padding_small)
                )
            ) {

                // SEND
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        val summary = buildString {
                            append("Order Details\n")
                            append("$numberOfCupcakes\n\n")
                            append("Flavors:\n")
                            flavorList.forEach {
                                append("• $it\n")
                            }
                            append("\nPickup Date: ${orderUiState.date}\n")
                            append("Total Price: ${orderUiState.price}")
                        }

                        onSendButtonClicked(newOrder, summary)
                    }
                ) {
                    Text(stringResource(R.string.send))
                }

                // CANCEL
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}

@Preview
@Composable
fun OrderSummaryPreview() {
    CupcakeTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(
                quantity = 12,
                flavor = "Vanilla, Chocolate, Coffee",
                date = "Jan 1",
                price = "$300.00"
            ),
            onCancelButtonClicked = {},
            onSendButtonClicked = { _, _ -> },
            modifier = Modifier.fillMaxHeight()
        )
    }
}