/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.ui.components.FormattedPriceLabel
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Composable that displays the list of options as [RadioButton] or [Checkbox] options,
 * [subtotal] and [onNextButtonClicked], [onCancelButtonClicked] buttons.
 */
@Composable
fun SelectOptionScreen(
    subtotal: String,
    options: List<String>,
    modifier: Modifier = Modifier,
    selectedOption: String = "",
    onSelectionChanged: (String) -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    isMultiSelect: Boolean = false
) {

    // Multi select state - initialized from selectedOption
    var selectedValues by rememberSaveable(selectedOption) {
        mutableStateOf(
            if (isMultiSelect && selectedOption.isNotEmpty()) {
                selectedOption.split(", ").toSet()
            } else {
                setOf<String>()
            }
        )
    }

    // Single select state - initialized from selectedOption
    var selectedValue by rememberSaveable(selectedOption) {
        mutableStateOf(if (!isMultiSelect) selectedOption else "")
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {

            options.forEach { item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = if (isMultiSelect)
                                selectedValues.contains(item)
                            else
                                selectedValue == item,

                            onClick = {
                                if (isMultiSelect) {
                                    selectedValues =
                                        if (selectedValues.contains(item)) {
                                            selectedValues - item
                                        } else {
                                            selectedValues + item
                                        }

                                    onSelectionChanged(
                                        selectedValues.joinToString(", ")
                                    )
                                } else {
                                    selectedValue = item
                                    onSelectionChanged(item)
                                }
                            }
                        )
                        .padding(
                            vertical = dimensionResource(R.dimen.padding_small)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // MULTI SELECT → CHECKBOX
                    if (isMultiSelect) {
                        Checkbox(
                            checked = selectedValues.contains(item),
                            onCheckedChange = null // Click is handled by the Row's selectable modifier
                        )
                    }
                    // SINGLE SELECT → RADIO BUTTON
                    else {
                        RadioButton(
                            selected = selectedValue == item,
                            onClick = null // Click is handled by the Row's selectable modifier
                        )
                    }

                    Text(
                        text = item,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }

            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(
                    bottom = dimensionResource(R.dimen.padding_medium)
                )
            )

            FormattedPriceLabel(
                subtotal = subtotal,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.padding_medium)
            ),
            verticalAlignment = Alignment.Bottom
        ) {

            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }

            Button(
                modifier = Modifier.weight(1f),

                // Enable logic based on mode
                enabled = if (isMultiSelect)
                    selectedValues.isNotEmpty()
                else
                    selectedValue.isNotEmpty(),

                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview
@Composable
fun SelectMultiOptionPreview() {
    CupcakeTheme {
        SelectOptionScreen(
            subtotal = "299.99",
            options = listOf("Vanilla", "Chocolate", "Coffee"),
            isMultiSelect = true,
            modifier = Modifier.fillMaxHeight()
        )
    }
}
