package models

import com.github.aselab.activerecord._


case class User(
  var name: String,
  var age: Int
) extends ActiveRecord

object User extends ActiveRecordCompanion[User]
