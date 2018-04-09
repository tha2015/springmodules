# Example about linking Spring-based modules via API interfaces

## Problems with @Import for linking modules

1. Not flexible enough for replacing module implementations (composition vs inheritance)
2. No separation between module configuration and module API

## A new way to define a module and its exposed API

1. class Bundle is used as a container for Spring context and it exposed API object
2. a Bundle is defined by a configuration class, an API interface, and dependent API objects

