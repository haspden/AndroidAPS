package info.nightscout.androidaps.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import info.nightscout.androidaps.database.TABLE_EXTENDED_BOLUSES
import info.nightscout.androidaps.database.embedments.InsulinConfiguration
import info.nightscout.androidaps.database.embedments.InterfaceIDs
import info.nightscout.androidaps.database.interfaces.DBEntry
import info.nightscout.androidaps.database.interfaces.DBEntryWithInsulinConfig
import info.nightscout.androidaps.database.interfaces.DBEntryWithTimeAndDuration

@Entity(tableName = TABLE_EXTENDED_BOLUSES,
        foreignKeys = [ForeignKey(
                entity = ExtendedBolus::class,
                parentColumns = ["id"],
                childColumns = ["referenceID"])])
data class ExtendedBolus(
        @PrimaryKey(autoGenerate = true)
        override var id: Long = 0,
        override var version: Int = 0,
        override var lastModified: Long = -1,
        override var valid: Boolean = true,
        override var referenceID: Long = 0,
        @Embedded
        override var interfaceIDs: InterfaceIDs = InterfaceIDs(),
        override var timestamp: Long,
        override var utcOffset: Long,
        override var duration: Long,
        var amount: Double,
        var emulatingTempBasal: Boolean,
        @Embedded
        override var insulinConfiguration: InsulinConfiguration
) : DBEntry, DBEntryWithTimeAndDuration, DBEntryWithInsulinConfig