package models

import org.squeryl.{Schema, KeyedEntity}

case class User(name: Option[String], age: Option[Int]) extends KeyedEntity[Long] {
  val id: Long = 0
}

object AppDB extends Schema {
  val user = table[User]("user")
}