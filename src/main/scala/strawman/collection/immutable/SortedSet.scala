package strawman.collection.immutable

import strawman.collection.{Sorted, SortedLike, SortedPolyTransforms}

/** Base trait for sorted sets */
trait SortedSet[A]
  extends Set[A]
    with Sorted[A]
    with SortedSetLike[A, SortedSet] // Inherited SortedSet operations return a `SortedSet`

trait SortedSetLike[A, +C[X] <: SortedSet[X]]
  extends SortedLike[A, C[A]]
    with SortedPolyTransforms[A, C]
    with SetLike[A, Set] // Inherited Set operations return a `Set`
    with SetMonoTransforms[A, C[A]] // Override the return type of Set ops to return C[A]
