package com.example.databasefun;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CarDao_Impl implements CarDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Car> __insertionAdapterOfCar;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByMake;

  public CarDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCar = new EntityInsertionAdapter<Car>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Car` (`id`,`car_make`,`car_name`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Car entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCarMake() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCarMake());
        }
        if (entity.getCarName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCarName());
        }
      }
    };
    this.__preparedStmtOfDeleteByMake = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "Delete from Car where car_make = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final Car... car) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCar.insert(car);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteByMake(final String carMake) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByMake.acquire();
    int _argIndex = 1;
    if (carMake == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, carMake);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteByMake.release(_stmt);
    }
  }

  @Override
  public List<Car> getAllCars() {
    final String _sql = "SELECT * from Car";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCarMake = CursorUtil.getColumnIndexOrThrow(_cursor, "car_make");
      final int _cursorIndexOfCarName = CursorUtil.getColumnIndexOrThrow(_cursor, "car_name");
      final List<Car> _result = new ArrayList<Car>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Car _item;
        final String _tmpCarMake;
        if (_cursor.isNull(_cursorIndexOfCarMake)) {
          _tmpCarMake = null;
        } else {
          _tmpCarMake = _cursor.getString(_cursorIndexOfCarMake);
        }
        final String _tmpCarName;
        if (_cursor.isNull(_cursorIndexOfCarName)) {
          _tmpCarName = null;
        } else {
          _tmpCarName = _cursor.getString(_cursorIndexOfCarName);
        }
        _item = new Car(_tmpCarMake,_tmpCarName);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
