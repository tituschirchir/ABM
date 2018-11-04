package client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dataaccess.helpers.DbObject;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecordBase;

public abstract class AvroHelper extends SpecificRecordBase implements DbObject {
    @Override
    @JsonIgnore
    public abstract Schema getSchema();

    @Override
    @JsonIgnore
    public abstract Object get(int field);
}
