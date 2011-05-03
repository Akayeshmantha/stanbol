package org.apache.stanbol.entityhub.indexing.core;

import org.apache.stanbol.entityhub.servicesapi.yard.Yard;

/**
 * The main indexing interface.
 * @author Rupert Westenthaler
 *
 */
public interface Indexer {
    /**
     * States of the Indexer
     * @author Rupert Westenthaler
     *
     */
    enum State {
        /**
         * After construction of the an instance
         */
        UNINITIALISED,
        /**
         * Indicates that the initialising of the {@link IndexingSource}s is on
         * the way.
         */
        INITIALISING,
        /**
         * All {@link IndexingSource}s are initialised, but the actual indexing
         * of the entities has not yet started.
         * This is the last opportunity to call {@link Indexer#setChunkSize(int)}
         * and {@link Indexer#setIndexAllEntitiesState(boolean)}
         */
        INITIALISED,
        /**
         * While the indexing of the entities is on the way.
         */
        INDEXING,
        /**
         * All Entities provided by the {@link IndexingSource}s are processed
         * and stored to the {@link IndexingTarget}.
         */
        INDEXED,
        /**
         * While the {@link IndexingTarget} is finalising the indexing process.
         */
        FINALISING,
        /**
         * Indicates that the indexing has finished and the {@link IndexingTarget}
         * has completed the finalisation. 
         */
        FINISHED
    };
    /**
     * The default number of documents sent in one chunk to the {@link Yard} 
     * provided by the configured {@link IndexingDestination}
     */
    public static final int DEFAULT_CHUNK_SIZE = 10;

    /**
     * Setter for the chunk size. parsing values &lt;= 0 results in the
     * chunk size to be set to {@link #DEFAULT_CHUNK_SIZE}. 
     * @param chunkSize the chunkSize to set
     * @throws IllegalStateException if {@link #getState()} &gt; 
     * {@link State#INITIALISED}
     */
    void setChunkSize(int chunkSize) throws IllegalStateException;

    /**
     * Getter for the chunk size (the number of entities that are indexed before
     * they are store to the {@link Yard}.
     * @return the chunkSize
     */
    int getChunkSize();

    /**
     * Getter for the Yard used to store the indexed entities.
     * @return the yard
     */
    Yard getYard();
    /**
     * Brings this indexer in the {@link State#INITIALISED} by initialising all 
     * {@link IndexingComponent}s.This method blocks until the  whole process is 
     * completed.Calls to this method are ignored if the indexer is not in the 
     * {@link State#UNINITIALISED} state.
     * <p>
     * This Method is intended to be used by caller that need more control over 
     * the indexing process as simple to call {@link #index()}.
     */
    void initialiseIndexingSources();
    /**
     * Brings this indexer in the {@link State#INDEXED} by indexing all Entities
     * provided by the {@link IndexingComponent}s. This method blocks until the  
     * whole process is completed. Calls to this method are ignored if the 
     * indexer is in a state greater than {@link State#INITIALISED}.
     * <p>
     * This Method is intended to be used by caller that need more control over 
     * the indexing process as simple to call {@link #index()}.
     * @throws IllegalStateException if {@link #getState()} &lt; 
     * {@link State#INITIALISED}
     */
    void indexAllEntities() throws IllegalStateException;
    /**
     * {@link State#FINISHED Finalises} the indexing process by calling finalise
     * on the {@link IndexingDestination}. This method blocks until the  
     * whole process is completed. Calls to this method are ignored if the 
     * indexer is in a state greater than {@link State#INDEXED}.
     * <p>
     * This Method is intended to be used by caller that need more control over 
     * the indexing process as simple to call {@link #index()}.
     * @throws IllegalStateException if {@link #getState()} &lt; 
     * {@link State#INDEXED}
     */
    void finaliseIndexingTarget() throws IllegalStateException;
    /**
     * Initialise the {@link IndexingComponent}s, indexes all entities and 
     * finalises the {@link IndexingDestination}. <p>
     * Calls to this method do have the same result as subsequent calls to 
     * {@link #initialiseIndexingSources()}, {@link #indexAllEntities()},
     * {@link #finaliseIndexingTarget()}. This method can also be used if any of
     * the mentioned three methods was already called to this indexer instance.
     * <p>
     * This method blocks until the whole process is completed. Ideal if the 
     * called does not need/want any further control over the indexing process.
     * <p>
     * To perform the indexing in the background one need to execute this
     * Method in an own {@link Thread}.
     */
    void index();

    /**
     * This allows to set the Indexer in an state that it also indexes entities
     * with an negative score. Typically Entities with a negative score are
     * considered to be marked as not to be indexed. However setting this state
     * to true allows to index also such entities.
     * @param indexAllEntitiesState the indexAllEntitiesState to set
     * @throws IllegalStateException if {@link #getState()} &gt; {@link State#INITIALISED}
     */
    void setIndexAllEntitiesState(boolean indexAllEntitiesState) throws IllegalStateException;

    /**
     * Getter  for the state if entities with a negative score are indexed or
     * not. The default is to exclude such entities. 
     * @return the indexAllEntitiesState
     */
    boolean isIndexAllEntitiesState();

    /**
     * The current state of the indexing process
     * @return the state
     */
    public abstract State getState();

}