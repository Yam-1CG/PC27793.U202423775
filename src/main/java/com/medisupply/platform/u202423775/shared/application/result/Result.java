package com.medisupply.platform.u202423775.shared.application.result;

import java.util.Optional;
import java.util.function.Function;

public sealed interface Result<T, E> {

    record Success<T, E>(T value) implements Result<T, E> {
    }

    record Failure<T, E>(E error) implements Result<T, E> {
    }

    static <T, E> Result<T, E> success(T value) {
        return new Success<>(value);
    }

    static <T, E> Result<T, E> failure(E error) {
        return new Failure<>(error);
    }

    default boolean isSuccess() {
        return this instanceof Success;
    }

    default boolean isFailure() {
        return this instanceof Failure;
    }

    default Optional<T> toOptional() {
        return switch (this) {
            case Success<T, E> s -> Optional.of(s.value());
            case Failure<T, E> f -> Optional.empty();
        };
    }

    default T getOrElse(T defaultValue) {
        return switch (this) {
            case Success<T, E> s -> s.value();
            case Failure<T, E> f -> defaultValue;
        };
    }

    default <E2> Result<T, E2> mapError(
            Function<E, E2> function) {
        return switch (this) {
            case Success<T, E> s ->
                    Result.success(s.value());
            case Failure<T, E> f ->
                    Result.failure(function.apply(f.error()));
        };
    }

    default <T2> Result<T2, E> map(
            Function<T, T2> function) {
        return switch (this) {
            case Success<T, E> s ->
                    Result.success(function.apply(s.value()));
            case Failure<T, E> f ->
                    Result.failure(f.error());
        };
    }

    default <T2> Result<T2, E> flatMap(
            Function<T, Result<T2, E>> function) {
        return switch (this) {
            case Success<T, E> s ->
                    function.apply(s.value());
            case Failure<T, E> f ->
                    Result.failure(f.error());
        };
    }

    default Result<T, E> recover(
            Function<E, Result<T, E>> function) {
        return switch (this) {
            case Success<T, E> s -> this;
            case Failure<T, E> f ->
                    function.apply(f.error());
        };
    }
}
