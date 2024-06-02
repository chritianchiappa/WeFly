package com.example.wefly

import android.os.Parcel
import android.os.Parcelable

// edit "tipoViaggio" and "partecipanti"

// Data displayed in the recycler view [titoloImmagine, titoloViaggio, citta, dataPartenza, budget]

data class DataViaggiAttuali(var titoloImmagine: Int, var titoloViaggio: String, var citta : String, var nazione : String, var dataPartenza : String, var dataRitorno: String, var budget: String, var tipoViaggio : String, var partecipanti : String, var affinita : String, var descrizione : String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(titoloImmagine)
        parcel.writeString(titoloViaggio)
        parcel.writeString(citta)
        parcel.writeString(nazione)
        parcel.writeString(dataPartenza)
        parcel.writeString(dataRitorno)
        parcel.writeString(budget)
        parcel.writeString(tipoViaggio)
        parcel.writeString(partecipanti)
        parcel.writeString(affinita)
        parcel.writeString(descrizione)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataViaggiAttuali> {
        override fun createFromParcel(parcel: Parcel): DataViaggiAttuali {
            return DataViaggiAttuali(parcel)
        }

        override fun newArray(size: Int): Array<DataViaggiAttuali?> {
            return arrayOfNulls(size)
        }
    }
}

